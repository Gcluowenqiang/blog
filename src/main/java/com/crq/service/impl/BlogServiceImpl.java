package com.crq.service.impl;

import com.crq.NotFoundException;
import com.crq.dao.BlogRepository;
import com.crq.demo.Blog;
import com.crq.demo.Type;
import com.crq.service.BlogService;
import com.crq.vo.BlogQuery;
import org.apache.commons.beanutils.BeanUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;

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
  public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
    return blogRepository.findAll(new Specification<Blog>() {
      /*处理动态查询的条件*/
      @Override
      public Predicate toPredicate(@NotNull Root<Blog> root, @NotNull CriteriaQuery<?> query, @NotNull CriteriaBuilder cb) {
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
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        return null;
      }
    }, pageable);
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
}
