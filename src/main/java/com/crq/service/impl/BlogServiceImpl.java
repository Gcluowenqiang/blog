package com.crq.service.impl;

import com.crq.NotFoundException;
import com.crq.dao.BlogRepository;
import com.crq.demo.Blog;
import com.crq.demo.Type;
import com.crq.service.BlogService;
import com.crq.util.MarkdownUtils;
import com.crq.vo.BlogQuery;
import org.apache.commons.beanutils.BeanUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * BlogServiceImpl
 *
 * @author crqyue
 * @since 2023-08-31 16:44
 */
@Service
public class BlogServiceImpl implements BlogService {
  @Autowired
  private BlogRepository blogRepository;

  @Transactional
  @Override
  public Blog getBlog(Long id) {
    return blogRepository.findById(id).get();
  }

  @Transactional
  @Override
  public Blog getAndConvert(Long id) throws InvocationTargetException, IllegalAccessException {
    Blog blog = blogRepository.findById(id).get();
    if (blog == null) {
      throw new NotFoundException("该博客不存在");
    }
    Blog b = new Blog();
    BeanUtils.copyProperties(b, blog);
    String content = b.getContent();
    b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));


    blogRepository.updateViews(id);
    return b;
  }

  @Transactional
  @Override
  public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
    /*处理动态查询的条件*/
    return blogRepository.findAll((Specification<Blog>) (root, query, cb) -> {
      ArrayList<Predicate> predicates = new ArrayList<>();
      if (!"".equals(blog.getTitle()) && blog.getTitle() != null) {
        predicates.add(cb.like(root.<String>get("title"), "%" + blog.getTitle() + "%"));
      }
      if (blog.getTypeId() != null) {
        predicates.add(cb.equal(root.<Type>get("type").get("id"), blog.getTypeId()));
      }
      if (blog.isRecommend()) {
        predicates.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
      }
      query.where(predicates.toArray(new Predicate[0]));
      return null;
    }, pageable);
  }

  @Override
  public Page<Blog> listBlog(Pageable pageable) {
    return blogRepository.findAll(pageable);
  }

  @Override
  public Page<Blog> listBlog(Long tagId, Pageable pageable) {
    return blogRepository.findAll(new Specification<Blog>() {
      @Override
      public Predicate toPredicate(@NotNull Root<Blog> root, @NotNull CriteriaQuery<?> cq, @NotNull CriteriaBuilder cb) {
        Join<Object, Object> join = root.join("tags");
        return cb.equal(join.get("id"), tagId);
      }
    }, pageable);
  }

  @Override
  public Page<Blog> listBlog(String query, Pageable pageable) {
    return blogRepository.findByQuery(query, pageable);
  }


  @Override
  public List<Blog> listRecommendBlogTop(Integer size) {
    Sort sort = Sort.by(Sort.Direction.DESC, "updateTime");
    Pageable pageable = PageRequest.of(0, size, sort);
    return blogRepository.findTop(pageable);
  }

  @Transactional
  @Override
  public Blog saveBlog(Blog blog) {
    if (blog.getId() == null) {
      // 创建时的初始化
      blog.setCreateTime(new Date());
      blog.setUpdateTime(new Date());
      blog.setViews(0);
    } else {
      blog.setUpdateTime(new Date());
    }
    return blogRepository.save(blog);
  }

  @Transactional
  @Override
  public Blog updateBlog(Long id, Blog blog) throws InvocationTargetException, IllegalAccessException {
    Blog b = blogRepository.findById(id).get();
    if (b == null) {
      throw new NotFoundException("此标签不存在");
    }
    BeanUtils.copyProperties(b, blog);
    return blogRepository.save(b);
  }

  @Transactional
  @Override
  public void deleteBlog(Long id) {
    blogRepository.deleteById(id);
  }

  @Override
  public Map<String, List<Blog>> archiveBlog() {
    List<String> years = blogRepository.findGroupYear();
    Map<String, List<Blog>> map = new HashMap<>();
    for (String year : years) {
      map.put(year, blogRepository.findByYear(year));
    }
    return map;
  }

  @Override
  public Long countBlog() {
    return blogRepository.count();
  }
}
