package com.crq.controller;

import com.crq.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author limi
 * @date 2017/10/23
 */
@Controller
public class ArchiveShowController {

  @Autowired
  private BlogService blogService;

/*  @GetMapping("/archives")
  public String archives(Model model) {
    model.addAttribute("archiveMap", blogService.archiveBlog());
    model.addAttribute("blogCount", blogService.countBlog());
    return "archives";
  }*/
}
