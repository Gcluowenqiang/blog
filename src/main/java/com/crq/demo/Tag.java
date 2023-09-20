package com.crq.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
<<<<<<< HEAD
 * Created by limi on 2017/10/14.
=======
 * @author limi
 * @date 2017/10/14
>>>>>>> 94ca38ff2d4143a83a2250cb9354ef66afb8fed7
 */
@Entity
@Table(name = "t_tag")
public class Tag {

  @Id
  @GeneratedValue
  private Long id;
  private String name;

  @ManyToMany(mappedBy = "tags")
  private List<Blog> blogs = new ArrayList<>();

  public Tag() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Blog> getBlogs() {
    return blogs;
  }

  public void setBlogs(List<Blog> blogs) {
    this.blogs = blogs;
  }

  @Override
  public String toString() {
    return "Tag{" +
      "id=" + id +
      ", name='" + name + '\'' +
      '}';
  }
}
