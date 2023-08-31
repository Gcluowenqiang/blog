package com.crq.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author limi
 * @date 2017/10/14
 */
/*@Entity 入库建表 @Table 指定表的名字*/
@Entity
@Table(name = "t_blog")
public class Blog {

  /*@Id 指定主键列 @GeneratedValue 指定该字段为自动增长列*/
  @Id
  @GeneratedValue
  private Long id;

  private String title;
  private String content;
  private String firstPicture;
  private String flag;
  private Integer views;
  private boolean appreciation;
  private boolean shareStatement;
  private boolean commentabled;
  private boolean published;
  private boolean recommend;

  /*@Temporal(TemporalType.TIMESTAMP)指定日期格式为 yyyy-MM-dd HH:mm:ss
  /*@Temporal(TemporalType.DATE)指定日期格式为 yyyy-MM-dd
  /*@Temporal(TemporalType.TIME)指定日期格式为 HH:mm:ss
  *
  * */
  @Temporal(TemporalType.TIMESTAMP)
  private Date createTime;
  @Temporal(TemporalType.TIMESTAMP)
  private Date updateTime;


  /*多对一关系 (维护方法)*/
  @ManyToOne
  private Type type;

  @ManyToMany(cascade = {CascadeType.PERSIST})
  private List<Tag> tags = new ArrayList<>();


  @ManyToOne
  private User user;


  /*一对多关系 (被维护方) 指定关系表的关系字段*/
  @OneToMany(mappedBy = "blog")
  private List<Comment> comments = new ArrayList<>();

  //不进行数据库映射
  @Transient
  private String tagIds;

  public String getTagIds() {
    return tagIds;
  }

  public void setTagIds(String tagIds) {
    this.tagIds = tagIds;
  }

  public Blog() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getFirstPicture() {
    return firstPicture;
  }

  public void setFirstPicture(String firstPicture) {
    this.firstPicture = firstPicture;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public Integer getViews() {
    return views;
  }

  public void setViews(Integer views) {
    this.views = views;
  }

  public boolean isAppreciation() {
    return appreciation;
  }

  public void setAppreciation(boolean appreciation) {
    this.appreciation = appreciation;
  }

  public boolean isShareStatement() {
    return shareStatement;
  }

  public void setShareStatement(boolean shareStatement) {
    this.shareStatement = shareStatement;
  }

  public boolean isCommentabled() {
    return commentabled;
  }

  public void setCommentabled(boolean commentabled) {
    this.commentabled = commentabled;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean published) {
    this.published = published;
  }

  public boolean isRecommend() {
    return recommend;
  }

  public void setRecommend(boolean recommend) {
    this.recommend = recommend;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }


  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }


  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  public void init() {
    this.tagIds = tagsToIds(this.getTags());
  }

  //1,2,3
  private String tagsToIds(List<Tag> tags) {
    if (!tags.isEmpty()) {
      StringBuffer ids = new StringBuffer();
      boolean flag = false;
      for (Tag tag : tags) {
        if (flag) {
          ids.append(",");
        } else {
          flag = true;
        }
        ids.append(tag.getId());
      }
      return ids.toString();
    } else {
      return tagIds;
    }
  }

  @Override
  public String toString() {
    return "Blog{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", content='" + content + '\'' +
      ", firstPicture='" + firstPicture + '\'' +
      ", flag='" + flag + '\'' +
      ", views=" + views +
      ", appreciation=" + appreciation +
      ", shareStatement=" + shareStatement +
      ", commentabled=" + commentabled +
      ", published=" + published +
      ", recommend=" + recommend +
      ", createTime=" + createTime +
      ", updateTime=" + updateTime +
      '}';
  }

}
