package com.crq.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BlogController
 *
 * @author crqyue
 * @since 2023-08-31 00:12
 */
@Controller
@RequestMapping("/admin")
public class BlogController {
  @GetMapping("/blogs")
  public String blogs() {
    return "admin/blogs";
  }
}
