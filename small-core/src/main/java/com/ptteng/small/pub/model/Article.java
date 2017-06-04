package com.ptteng.small.pub.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name =  "article")
public class Article implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8751915544773635072L;  
    
        
    /**
     *  未发布
     * 
     */
    public static final Integer Status_Unpublished = 0;

    /**
     * 发布
     */
    public static final Integer Status_Published = 1;

    /**
     *  已删除
     * 
     */
    public static final Long Status_Deleted = 0L;
    
    /**
     * type字段常量：关于我们
     * 0
     */
    public static final Integer About_Us = 0;
    
    /**
     * type字段常量：帮助中心
     * 1
     */
    public static final Integer Help_Center = 1;
        
     
    private Long id;
    
     
    private Integer type;
    
     
    private String img;
    
     
    private String title;
    
     
    private Integer orderBy;
    
     
    private String author;
    
     
    private String source;
    
     
    private String content;
    
     
    private String summary;
    
     
    private Long createBy;
    
     
    private Long updateBy;
    
     
    private Long publishat;
    
     
    private Long updateAt;
    
     
    private Long createAt;
    
    private String createTime;
    
    private Long preId;
    private Long nextId;
    @Transient
    public Long getPreId() {
		return preId;
	}


	public void setPreId(Long preId) {
		this.preId = preId;
	}

	@Transient
	public Long getNextId() {
		return nextId;
	}


	public void setNextId(Long nextId) {
		this.nextId = nextId;
	}


	@Transient
    public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	private Integer status;

    private String url;
    
    private Long industry;
    private Integer isBanner;
    @Column(name = "is_banner")
    public Integer getIsBanner() {
		return isBanner;
	}


	public void setIsBanner(Integer isBanner) {
		this.isBanner = isBanner;
	}

	private Integer isTop;
    @Column(name = "is_top")
    public Integer getIsTop() {
		return isTop;
	}


	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}
    
    private Integer thumbUpNum;
    @Column(name = "thumb_up_num")
    public Integer getThumbUpNum() {
		return thumbUpNum;
	}


	public void setThumbUpNum(Integer thumbUpNum) {
		this.thumbUpNum = thumbUpNum;
	}

	@Column(name = "comment_num")
	public Integer getCommentNum() {
		return commentNum;
	}


	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	@Column(name = "play_num")
	public Integer getPlayNum() {
		return playNum;
	}


	public void setPlayNum(Integer playNum) {
		this.playNum = playNum;
	}


	private Integer commentNum;
    
    private Integer playNum;
    



                @Id
           @GeneratedValue(strategy = GenerationType.AUTO)
                @Column(name = "id")
    public Long getId() {
        return id;
    }
    
    
    public void setId(Long id) {
        this.id = id;
    }
            @Column(name = "type")
    public Integer getType() {
        return type;
    }
    
    
    public void setType(Integer type) {
        this.type = type;
    }
            @Column(name = "img")
    public String getImg() {
        return img;
    }
    
    
    public void setImg(String img) {
        this.img = img;
    }
            @Column(name = "title")
    public String getTitle() {
        return title;
    }
    
    
    public void setTitle(String title) {
        this.title = title;
    }
            @Column(name = "orderBy")
    public Integer getOrder() {
        return orderBy;
    }
    
    
    public void setOrder(Integer orderBy) {
        this.orderBy = orderBy;
    }
            @Column(name = "author")
    public String getAuthor() {
        return author;
    }
    
    
    public void setAuthor(String author) {
        this.author = author;
    }
            @Column(name = "source")
    public String getSource() {
        return source;
    }
    
    
    public void setSource(String source) {
        this.source = source;
    }
            @Column(name = "content")
    public String getContent() {
        return content;
    }
    
    
    public void setContent(String content) {
        this.content = content;
    }
            @Column(name = "summary")
    public String getSummary() {
        return summary;
    }
    
    
    public void setSummary(String summary) {
        this.summary = summary;
    }
            @Column(name = "create_by")
    public Long getCreateBy() {
        return createBy;
    }
    
    
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
            @Column(name = "update_by")
    public Long getUpdateBy() {
        return updateBy;
    }
    
    
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
            @Column(name = "publish_at")
    public Long getPublishat() {
        return publishat;
    }
    
    
    public void setPublishat(Long publishat) {
        this.publishat = publishat;
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
            @Column(name = "status")
    public Integer getStatus() {
        return status;
    }
    
    
    public void setStatus(Integer status) {
        this.status = status;
    }


    @Column(name = "url")
    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url= url;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }
    
    @Column(name = "industry")
    public Long getIndustry() {
        return industry;
    }


    public void setIndustry(Long industry) {
        this.industry = industry;
    }

}

