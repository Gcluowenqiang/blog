package com.crq.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 捕获全局的异常，并记录异常信息,返回相应的错误信息页面或者直接抛出异常。这样可以实现统一的异常处理逻辑，提高代码的可维护性和可读性
 *
 * @author limi
 * @date 2017/10/13
 */
@ControllerAdvice
public class ControllerExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());


  @ExceptionHandler(Exception.class)
  public ModelAndView exceptionHander(HttpServletRequest request, Exception e) throws Exception {
    //使用logger.error()方法将请求的URL和异常信息记录到日志中
    logger.error("Requst URL : {}，Exception : {}", request.getRequestURL(), e);

    //判断异常类上是否存在@ResponseStatus注解，如果存在，则说明该异常已经被其他地方处理过，直接抛出异常
    if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
      throw e;
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("url", request.getRequestURL());
    mv.addObject("exception", e);
    mv.setViewName("error/error");
    return mv;
  }
}
