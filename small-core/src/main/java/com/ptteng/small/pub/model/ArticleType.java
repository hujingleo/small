package com.ptteng.small.pub.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name =  "article_type")
public class ArticleType implements Serializable {

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
    
        
     
    private Long id;
    
     
    
    
     
    private Long createBy;
    
     
    private Long updateBy;
    
    
     
    private Long updateAt;
    
     
    private Long createAt;
    
     
    private Integer status;
    
    private Integer isTop;

    @Column(name = "is_top")
	public Integer getIsTop() {
		return isTop;
	}


	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}


	private String name;
    @Column(name = "name")
    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sort")
	public Integer getSort() {
		return sort;
	}


	public void setSort(Integer sort) {
		this.sort = sort;
	}


	private Integer sort;
    



                @Id
           @GeneratedValue(strategy = GenerationType.AUTO)
                @Column(name = "id")
    public Long getId() {
        return id;
    }
    
    
    public void setId(Long id) {
        this.id = id;
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


}

