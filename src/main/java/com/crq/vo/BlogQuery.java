package com.crq.vo;

/**
 * BlogQuery 辅助类-推荐状态
 *
 * @author crqyue
 * @since 2023-08-31 19:06
 */
public class BlogQuery {
  private String title;
  private Long typeId;
  private boolean recommend;

  public BlogQuery() {
  }

  public boolean isRecommend() {
    return recommend;
  }

  public void setRecommend(boolean recommend) {
    this.recommend = recommend;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Long getTypeId() {
    return typeId;
  }

  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }
}
