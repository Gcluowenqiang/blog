package com.crq;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
<<<<<<< HEAD
 * Created by limi on 2017/10/13.
=======
 * @author limi
 * @date 2017/10/13
>>>>>>> 94ca38ff2d4143a83a2250cb9354ef66afb8fed7
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
