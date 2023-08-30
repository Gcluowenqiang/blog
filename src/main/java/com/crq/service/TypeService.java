package com.crq.service;

import com.crq.demo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.InvocationTargetException;

/**
 * TypeService
 *
 * @author crqyue
 * @since 2023-08-31 01:05
 */
public interface TypeService {
  Type saveType(Type type);

  Type getType(Long id);

  Type getTypeByName(String name);

  Page<Type> listType(Pageable pageable);

  Type updateType(Long id, Type type) throws InvocationTargetException, IllegalAccessException;

  void deleteType(Long id);

}

