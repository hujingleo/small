package com.ptteng.small.pub.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2126050725125880832L;


    private Long id;


    private String openId;

    private Long articleId;
    private String content;


    private Long updateAt;


    private Long createAt;
    
    private String createTime;

    @Transient
    public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "article_id")
    public Long getArticleId() {
        return articleId;
    }


    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Column(name = "open_id")
    public String getOpenId() {
        return openId;
    }


    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "update_at")
    public Long getUpdateAt() {
        return updateAt;
    }


    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    @Column(name = "create_at")
    public Long getCreateAt() {
        return createAt;
    }


    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

}

