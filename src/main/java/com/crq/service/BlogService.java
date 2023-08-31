package com.crq.service;

import com.crq.demo.Blog;
import com.crq.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.InvocationTargetException;

/**
 * BlogService
 *
 * @author crqyue
 * @since 2023-08-31 16:41
 */
public interface BlogService {
  Blog getBlog(Long id);

  Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

  Blog saveBlog(Blog blog);

  Blog updateBlog(Long ig, Blog blog) throws InvocationTargetException, IllegalAccessException;

  void deleteBlog(Long id);
}

