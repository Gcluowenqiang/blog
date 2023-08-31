package com.crq.controller.admin;

import com.crq.demo.Blog;
import com.crq.demo.User;
import com.crq.service.BlogService;
import com.crq.service.TagService;
import com.crq.service.TypeService;
import com.crq.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * BlogController
 *
 * @author crqyue
 * @since 2023-08-31 00:12
 */
@Controller
@RequestMapping("/admin")
public class BlogController {
  private static final String INPUT = "/admin/blogs-input";
  private static final String LIST = "/admin/blogs";
  private static final String REDIRECT_LIST = "redirect:/admin/blogs";

  @Autowired
  private BlogService blogService;
  @Autowired
  private TypeService typeService;
  @Autowired
  private TagService tagService;

  @GetMapping("/blogs")
  public String blogs(@PageableDefault(size = 2, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                      BlogQuery blog, Model model) {
    model.addAttribute("types", typeService.listType());
    model.addAttribute("page", blogService.listBlog(pageable, blog));
    return LIST;
  }

  @PostMapping("/blogs/search")
  public String search(@PageableDefault(size = 2, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                       BlogQuery blog, Model model) {
    model.addAttribute("page", blogService.listBlog(pageable, blog));
    /*返回blogs页面下的一个片段*/
    return "admin/blogs :: blogList";
  }

  @GetMapping("/blogs/input")
  public String input(Model model) {
    setTypeAndTag(model);
    model.addAttribute("blog", new Blog());
    return INPUT;
  }

  private void setTypeAndTag(Model model) {
    model.addAttribute("types", typeService.listType());
    model.addAttribute("tags", tagService.listTag());
  }

  @GetMapping("/blogs/{id}/input")
  public String editInput(Model model, @PathVariable Long id) {
    setTypeAndTag(model);
    Blog blog = blogService.getBlog(id);
    blog.init();
    model.addAttribute("blog", blog);
    return INPUT;
  }


  @PostMapping("/blogs")
  public String post(Blog blog, RedirectAttributes attributes, HttpSession session) {
    //拿到登录用户
    blog.setUser((User) session.getAttribute("user"));
    blog.setType(typeService.getType(blog.getType().getId()));
    System.out.println("查询到的分类" + tagService.listTag(blog.getTagIds()));
    blog.setTags(tagService.listTag(blog.getTagIds()));
    System.out.println("查询到的标签" + tagService.listTag(blog.getTagIds()));
    Blog b = blogService.saveBlog(blog);
    if (b == null) {
      attributes.addFlashAttribute("message", "操作失败");
    } else {
      attributes.addFlashAttribute("message", "操作成功");
    }
    return REDIRECT_LIST;
  }

  @GetMapping("/blogs/{id}/delete")
  public String delete(@PathVariable Long id, RedirectAttributes attributes) {
    blogService.deleteBlog(id);
    attributes.addFlashAttribute("message", "删除成功");
    return REDIRECT_LIST;
  }
}
