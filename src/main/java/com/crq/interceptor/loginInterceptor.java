package com.crq.interceptor;


import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginInterceptor
 *
 * @author crqyue
 * @since 2023-08-31 00:15
 */
/*登录拦截器过滤*/
/*HandlerInterceptorAdapter此继承类已经过时,取而代之的时用HandlerInterceptor接口来实现相同效果*/
public class loginInterceptor implements HandlerInterceptor {
  /*@NotNull 编译时检测可能的空指针异常,提供更好的代码可读性和可维护性*/
  @Override
  public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
    // 在请求处理之前进行拦截，可以在此处进行登录验证等操作
    // 返回true表示继续处理请求，返回false表示拦截请求
    //判断用户是否登录，未登录重定向到登录页面
    if (request.getSession().getAttribute("user") == null) {
      response.sendRedirect("/admin");
      return false;
    }
    return true;
  }

  @Override
  public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
    // 请求处理之后进行拦截，可以在此处添加一些公共的模型数据等操作
  }

  @Override
  public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) throws Exception {
    // 请求完成之后进行拦截，可以在此处进行一些资源清理操作
  }

}
