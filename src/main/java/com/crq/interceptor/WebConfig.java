package com.crq.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 *
 * @author crqyue
 * @since 2023-08-31 00:31
 */
/*配置拦截适配器*/
@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //加载登录适配器
    registry.addInterceptor(new loginInterceptor())
      .addPathPatterns("/admin/**")//拦截admin/**路径
      .excludePathPatterns("/admin")//排除必要路劲,以便可以访问
      .excludePathPatterns("/admin/login");
  }
}
