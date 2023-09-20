package com.crq.controller.admin;

import com.crq.demo.Type;
import com.crq.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

/**
 * TypeController
 *
 * @author crqyue
 * @since 2023-08-31 01:28
 */
@Controller
@RequestMapping("/admin")
public class TypeController {
  @Autowired
  private TypeService typeService;

  /**
   * @param pageable 分页参数数据由前台后去 指定每页条数 根据id参数进行sort倒叙
   * @return
   */
  @GetMapping("/types")
  public String types(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC)
                      Pageable pageable,
                      Model model) {
    model.addAttribute("page", typeService.listType(pageable));
    return "/admin/types";
  }

  /*跳转到新增页面*/
  @GetMapping("/types/input")
  public String input(Model model) {
    model.addAttribute("type", new Type());
    return "/admin/types-input";
  }

  @GetMapping("/types/{id}/input")
  public String editInput(@PathVariable Long id, Model model) {
    model.addAttribute("type", typeService.getType(id));
    return "admin/types-input";
  }


  /*save*/

  /**
   * @param type       @Valid 校验type对象
   * @param result     BindingResult 得到校验之后的结果
   * @param attributes
   * @return 注意点:校验类和对象类必须紧挨
   */
  @PostMapping("/types")
  public String save(@Valid Type type, BindingResult result, RedirectAttributes attributes) {
    //增加前校验表中的分类名称是否重复
    Type t = typeService.getTypeByName(type.getName());
    if (t != null) {
      result.rejectValue("name", "nameError", "不能重复添加分类");
    }
    if (result.hasErrors()) {//校验没通过返回input页面
      return "/admin/types-input";
    }
    Type type1 = typeService.saveType(type);
    if (type1 == null) {
      attributes.addFlashAttribute("message", "新增失败");
    } else {
      attributes.addFlashAttribute("message", "新增成功");
    }
    return "redirect:/admin/types";
  }


  @PostMapping("/types/{id}")
  public String editPost(@Valid Type type, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) throws InvocationTargetException, IllegalAccessException {
    //增加前校验表中的分类名称是否重复
    Type t = typeService.getTypeByName(type.getName());
    if (t != null) {
      result.rejectValue("name", "nameError", "不能重复添加分类");
    }
    if (result.hasErrors()) {//校验没通过返回input页面
      return "/admin/types-input";
    }
    System.out.println(id + "----" + type);
    Type type1 = typeService.updateType(id, type);
    if (type1 == null) {
      attributes.addFlashAttribute("message", "更新失败");
    } else {
      attributes.addFlashAttribute("message", "更新成功");
    }
    return "redirect:/admin/types";
  }

  @GetMapping("/types/{id}/delete")
  public String delete(@PathVariable Long id, RedirectAttributes attributes) {
    typeService.deleteType(id);
    attributes.addFlashAttribute("message", "删除成功");
    return "redirect:/admin/types";
  }
}
