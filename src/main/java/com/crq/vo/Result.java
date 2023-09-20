package com.crq.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author crqyue
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
  private Boolean flag;
  private String msg;
  private Object data;

  public static Result success(String msg) {
    return new Result(true, msg, null);
  }

  public static Result success(String msg, Object data) {
    return new Result(true, msg, data);
  }

  public static Result error(String msg) {
    return new Result(false, msg, null);
  }

}