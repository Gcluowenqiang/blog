package com.crq.service;

import com.crq.demo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * TagService
 *
 * @author crqyue
 * @since 2023-08-31 13:58
 */
public interface TagService {
  Tag saveTag(Tag type);

  Tag getTag(Long id);

  Tag getTagByName(String name);

  Page<Tag> listTag(Pageable pageable);

  List<Tag> listTag();

  List<Tag> listTag(String ids);

  Tag updateTag(Long id, Tag type) throws InvocationTargetException, IllegalAccessException;

  void deleteTag(Long id);


}

