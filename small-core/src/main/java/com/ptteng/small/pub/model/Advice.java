package com.ptteng.small.pub.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by hujin on 2017/5/17.
 */

@Entity
@Table(name = "advice")
public class Advice implements Serializable {

	private static final long serialVersionUID = 8779572405452668928L;	
    private Long id;
    private String openId;


    private String description;
    private String contactInformation;
    private Long updateAt;
    private Long createAt;
    private String replyContent;
    @Column(name = "reply_content")
    public String getReplyContent() {
		return replyContent;
	}
    
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
    @Column(name = "status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	private Integer status;

	   @Id
@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "open_id")
    public String getOpenId() {return openId;}

    public void setOpenId(String openId) {this.openId = openId;}
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "contact_information")
    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
    @Column(name = "update_at")
    public Long getCreateBy() {
        return updateAt;
    }

    public void setCreateBy(Long createBy) {
        this.updateAt = createBy;
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
