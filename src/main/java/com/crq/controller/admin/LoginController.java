package com.crq.controller.admin;


import com.crq.demo.User;
import com.crq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * LoginController
 *
 * @author crqyue
 * @since 2023-08-30 22:59
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

  //service 注入
  @Autowired
  private UserService userService;

  /*跳转到登录页面*/
  @GetMapping
  public String loginPage() {
    return "admin/login";
  }

  /*登录操作*/
  @PostMapping("/login")
  public String login(String username, String password, HttpSession session,
                      RedirectAttributes attributes, Model model) {
    User user = userService.checkUser(username, password);
    if (user == null) {
      attributes.addFlashAttribute("message", "用户名和密码错误");
      return "redirect:/admin";
    }
    //进行用户信息存储
    session.setAttribute("user", user);
    return "/admin/index";
  }

  /*注销用户*/
  @GetMapping("/logout")
  public String logout(HttpSession session) {
    //移除用户信息
    session.removeAttribute("user");
    return "redirect:/admin";
  }
}
