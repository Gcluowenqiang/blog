package com.crq;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 定义一个自定义的运行时异常类NotFoundException，并将该异常映射到HTTP响应状态码404，方便在业务逻辑中抛出该异常并进行相应的处理
 *
 * @author limi
 * @date 2017/10/13
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

  public NotFoundException() {
  }

  public NotFoundException(String message) {
    super(message);
  }

  public NotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
