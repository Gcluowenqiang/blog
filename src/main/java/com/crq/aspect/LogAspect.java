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
 * 实现一个AOP切面，用于在Controller层的方法执行前记录请求的信息并输出到日志中
 *
 * @author limi
 * @date 2017/10/13
 */
@Aspect
@Component
public class LogAspect {

  //定义Logger对象，用于记录日志。
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  //定义切点，使用@Pointcut注解标记，指定了切点表达式，表示所有com.crq.controller包下的所有方法都是切点
  @Pointcut("execution(* com.crq.controller.*.*(..))")
  public void log() {
  }


  //定义前置通知（Before Advice）方法，使用@Before注解标记，并指定了切点方法log()
  //
  @Before("log()")
  public void doBefore(JoinPoint joinPoint) {
    //通过RequestContextHolder获取当前请求的ServletRequestAttributes对象，然后获取HttpServletRequest对象，进而获取请求的URL和IP地址
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    assert attributes != null;
    HttpServletRequest request = attributes.getRequest();
    String url = request.getRequestURL().toString();
    String ip = request.getRemoteAddr();
    //使用joinPoint.getSignature()获取方法的签名信息，包括所在类的全限定名和方法名，拼接成classMethod字符串
    String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
    //使用joinPoint.getArgs()获取方法的参数，存储到args数组中。
    Object[] args = joinPoint.getArgs();
    RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
    //使用logger.info()方法将RequestLog对象输出到日志中
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

  private static class RequestLog {
    private final String url;
    private final String ip;
    private final String classMethod;
    private final Object[] args;

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
