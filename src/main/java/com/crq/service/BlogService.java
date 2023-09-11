package com.crq.service;

import com.crq.demo.Blog;
import com.crq.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * BlogService
 *
 * @author crqyue
 * @since 2023-08-31 16:41
 */
public interface BlogService {
  Blog getBlog(Long id);

  Blog getAndConvert(Long id) throws InvocationTargetException, IllegalAccessException;

  Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

  Page<Blog> listBlog(Pageable pageable);

  Page<Blog> listBlog(String query, Pageable pageable);

  List<Blog> listRecommendBlogTop(Integer size);

  Blog saveBlog(Blog blog);

  Blog updateBlog(Long ig, Blog blog) throws InvocationTargetException, IllegalAccessException;

  void deleteBlog(Long id);
}

