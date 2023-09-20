package com.crq.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
<<<<<<< HEAD
 * Created by limi on 2017/10/13.
=======
 * @author limi
 * @date 2017/10/13
>>>>>>> 94ca38ff2d4143a83a2250cb9354ef66afb8fed7
 */
@Aspect
@Component
public class LogAspect {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

<<<<<<< HEAD
  @Pointcut("execution(* com.lrm.web.*.*(..))")
=======
  @Pointcut("execution(* com.crq.controller.*.*(..))")
>>>>>>> 94ca38ff2d4143a83a2250cb9354ef66afb8fed7
  public void log() {
  }


  @Before("log()")
  public void doBefore(JoinPoint joinPoint) {
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
<<<<<<< HEAD
=======
    assert attributes != null;
>>>>>>> 94ca38ff2d4143a83a2250cb9354ef66afb8fed7
    HttpServletRequest request = attributes.getRequest();
    String url = request.getRequestURL().toString();
    String ip = request.getRemoteAddr();
    String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();
    RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
    logger.info("Request : {}", requestLog);
  }

  @After("log()")
  public void doAfter() {
//        logger.info("--------doAfter--------");
  }

  @AfterReturning(returning = "result", pointcut = "log()")
  public void doAfterRuturn(Object result) {
    logger.info("Result : {}", result);
  }

<<<<<<< HEAD
  private class RequestLog {
    private String url;
    private String ip;
    private String classMethod;
    private Object[] args;
=======
  private static class RequestLog {
    private final String url;
    private final String ip;
    private final String classMethod;
    private final Object[] args;
>>>>>>> 94ca38ff2d4143a83a2250cb9354ef66afb8fed7

    public RequestLog(String url, String ip, String classMethod, Object[] args) {
      this.url = url;
      this.ip = ip;
      this.classMethod = classMethod;
      this.args = args;
    }

    @Override
    public String toString() {
      return "{" +
        "url='" + url + '\'' +
        ", ip='" + ip + '\'' +
        ", classMethod='" + classMethod + '\'' +
        ", args=" + Arrays.toString(args) +
        '}';
    }
  }

}
