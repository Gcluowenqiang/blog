package com.crq.service.impl;

import com.crq.NotFoundException;
import com.crq.dao.TypeRepository;
import com.crq.demo.Type;
import com.crq.service.TypeService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;

/**
 * TypeServiceImpl
 *
 * @author crqyue
 * @since 2023-08-31 01:07
 */
@Service
public class TypeServiceImpl implements TypeService {
  //注入
  @Autowired
  private TypeRepository typeRepository;

  /*事务*/
  @Transactional
  @Override
  public Type saveType(Type type) {
    return typeRepository.save(type);
  }

  @Transactional
  @Override
  public Type getType(Long id) {
    //findOne已弃用
    return typeRepository.findById(id).get();
  }

  @Transactional
  @Override
  public Type getTypeByName(String name) {
    return typeRepository.findByName(name);
  }

  @Transactional
  @Override
  public Page<Type> listType(Pageable pageable) {
    return typeRepository.findAll(pageable);
  }

  @Transactional
  @Override
  public Type updateType(Long id, Type type) throws InvocationTargetException, IllegalAccessException {
    Type t = typeRepository.findById(id).get();
    if (t == null) {
      throw new NotFoundException("不存在该类型");
    }
    //将查到的对象有t进行覆盖(后覆盖前)
    BeanUtils.copyProperties(t, type);
    return typeRepository.save(t);
  }

  @Transactional
  @Override
  public void deleteType(Long id) {
    typeRepository.deleteById(id);
  }
}
