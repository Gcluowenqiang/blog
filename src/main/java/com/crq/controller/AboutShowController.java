package com.crq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author limi 关于我
 * @date 2017/10/24
 */
@Controller
public class AboutShowController {

  @GetMapping("/about")
  public String about() {
    return "about";
  }
}
