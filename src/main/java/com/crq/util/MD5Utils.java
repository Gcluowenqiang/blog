package com.crq.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5Utils
 *
 * @author crqyue
 * @since 2023-08-31 00:05
 */
public class MD5Utils {
  /**
   * MD5加密类
   *
   * @param str 要加密的字符串
   * @return 加密后的字符串
   */
  public static String code(String str) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(str.getBytes());
      byte[] byteDigest = md.digest();
      int i;
      StringBuilder buf = new StringBuilder();
      for (byte b : byteDigest) {
        i = b;
        if (i < 0) {
          i += 256;
        }
        if (i < 16) {
          buf.append("0");
        }
        buf.append(Integer.toHexString(i));
      }
      //32位加密
      return buf.toString();
      // 16位的加密
      //return buf.toString().substring(8, 24);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }

  }

  /*测试加密*/
  public static void main(String[] args) {
    System.out.println(code("vvv222lwq"));
  }
}
