package com.crq.service.impl;

import com.crq.NotFoundException;
import com.crq.dao.TagRepository;
import com.crq.demo.Tag;
import com.crq.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * TagServiceImpl
 *
 * @author crqyue
 * @since 2023-08-31 13:59
 */
@Service
public class TagServiceImpl implements TagService {
  //注入
  @Autowired
  private TagRepository tagRepository;

  @Transactional
  @Override
  public Tag saveTag(Tag tag) {
    return tagRepository.save(tag);
  }

  @Transactional
  @Override
  public Tag getTag(Long id) {
    return tagRepository.findById(id).get();
  }

  @Transactional
  @Override
  public Tag getTagByName(String name) {
    return tagRepository.findByName(name);
  }

  @Transactional
  @Override
  public Page<Tag> listTag(Pageable pageable) {
    return tagRepository.findAll(pageable);
  }

  @Transactional
  @Override
  public List<Tag> listTag() {
    return tagRepository.findAll();
  }

  @Transactional
  @Override
  public List<Tag> listTag(String ids) {
    return tagRepository.findAllById(concerToList(ids));
  }

  private List<Long> concerToList(String ids) {
    List<Long> list = new ArrayList<>();
    if (!"".equals(ids) && ids != null) {
      String[] split = ids.split(",");
      for (int i = 0; i < split.length; i++) {
        list.add(new Long(split[i]));
      }
    }
    return list;
  }

  @Transactional
  @Override
  public Tag updateTag(Long id, Tag tag) throws InvocationTargetException, IllegalAccessException {
    Tag t = tagRepository.findById(id).get();
    if (t == null) {
      throw new NotFoundException("不存在该标签");
    }
    //对其复制并且覆盖（后覆盖前）
    //注意BeanUtils导包
    org.apache.commons.beanutils.BeanUtils.copyProperties(t, tag);
    return tagRepository.save(t);
  }


  @Transactional
  @Override
  public void deleteTag(Long id) {
    tagRepository.deleteById(id);
  }
}
