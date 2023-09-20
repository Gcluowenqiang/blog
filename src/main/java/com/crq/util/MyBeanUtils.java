package com.crq.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 * 提供一个便捷的方法，用于获取一个对象中所有属性值为空的属性名数组，方便进行属性校验或其他业务逻辑处理 *
 *
 * @author limi
 * @date 2017/10/21
 */
public class MyBeanUtils {


  /**
   * 定义了一个静态方法getNullPropertyNames()，接收一个Object类型的参数source，表示要检查的对象
   *
   * @param source
   * @return
   */
  public static String[] getNullPropertyNames(Object source) {
    //使用BeanWrapperImpl类创建一个BeanWrapper对象beanWrapper，用于访问和操作对象的属性
    BeanWrapper beanWrapper = new BeanWrapperImpl(source);
    //获取对象所有属性描述符PropertyDescriptor数组
    PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
    List<String> nullPropertyNames = new ArrayList<>();
    for (PropertyDescriptor pd : pds) {
      //对于每个属性描述符pd，获取属性名propertyName
      String propertyName = pd.getName();
      //获取对象的属性值，如果属性值为null，则将属性名propertyName添加到nullPropertyNames集合中
      if (beanWrapper.getPropertyValue(propertyName) == null) {
        nullPropertyNames.add(propertyName);
      }
    }
    return nullPropertyNames.toArray(new String[0]);
  }

}
