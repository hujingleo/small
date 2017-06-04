package com.ptteng.small.pub.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "constant")
public class Constant implements Serializable, Comparable<Constant> {

    /**
     *
     */
    private static final long serialVersionUID = 4142447767937843200L;
    /**
     * 参数设置：type=params 体验金mykey：score，value：200000|2|2000
     */
    public static final String PARAMS = "params";

    private Long id;

    private String mykey;

    private String value;

    private String type;

    private Long updateAt;

    private Long createAt;

    private Long updateBy;

    private Long createBy;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "mykey")
    public String getMykey() {
        return mykey;
    }

    public void setMykey(String mykey) {
        this.mykey = mykey;
    }

    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Column(name = "update_by")
    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    @Column(name = "create_by")
    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public int compareTo(Constant o) {
        Integer mykey = Integer.valueOf(o.getMykey());
        Integer thisMykey = Integer.valueOf(this.getMykey());

        // 对字段进行升序，如果欲降序可采用before方法
        if (thisMykey > mykey) {
            return -1;
        }
        if (thisMykey < mykey) {
            return 1;
        }
        return 0;

    }

}
