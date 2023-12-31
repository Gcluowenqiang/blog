package com.crq.controller;

import com.crq.demo.Blog;
import com.crq.service.BlogService;
import com.crq.service.TagService;
import com.crq.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author limi
 * @date 2017/10/13
 */
@Controller
public class IndexController {
  @Autowired
  private BlogService blogService;

  @Autowired
  private TypeService typeService;

  @Autowired
  private TagService tagService;

  //findall
  @GetMapping("/")
  public String index(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                      Model model) {
    List<Blog> content = blogService.listBlog(pageable).getContent();
    model.addAttribute("page", blogService.listBlog(pageable));
    model.addAttribute("types", typeService.listTypeTop(6));
    model.addAttribute("tags", tagService.listTagTop(10));
    model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));
    return "index";
  }


  //全局search
  @PostMapping("/search")
  public String search(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                       @RequestParam String query, Model model) {
    System.out.println("-----------------------------");
    model.addAttribute("page", blogService.listBlog("%" + query + "%", pageable));
    model.addAttribute("query", query);
    return "search";
  }


  //单个博客显示
  @GetMapping("/blog/{id}")
  public String blog(@PathVariable Long id, Model model) throws InvocationTargetException, IllegalAccessException {
    model.addAttribute("blog", blogService.getAndConvert(id));
    return "blog";
  }


  //获取最新发布的前三个博客
  @GetMapping("/footer/newblog")
  public String newblogs(Model model) {
    model.addAttribute("newblogs", blogService.listRecommendBlogTop(3));
    System.out.println(blogService.listRecommendBlogTop(3) + "---------------");
    return "_fragments :: newblogList";
  }

}
