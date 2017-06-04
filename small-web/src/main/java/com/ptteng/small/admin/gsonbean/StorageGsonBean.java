package com.ptteng.small.admin.gsonbean;

/**
 * 用于生成报告审计详情的停放地址json数据
 * 
 * @author liut
 *
 */
public class StorageGsonBean {
  
  
  public static final String HEAD_NAME = "本部";
  
  public static final String SECOND_NAME = "二网";
  
  public static final String TEM_NAME = "临展";
  
  /**
   * 库位属性名称：本部or二网or临展
   */
  private String attributeName;
  
  /**
   * 店名
   */
  private String name;
  
  /**
   * 地址
   */
  private String address;
  
  /**
   * 联系人
   */
  private String contactsName;
  
  /**
   * 联系电话
   */
  private String contactsPhone;
  
  /**
   * 车辆数
   */
  private Integer carNum;
  
  /**
   * 备注
   */
  private String comment;
  
  public String getAttributeName() {
    return attributeName;
  }
  
  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getContactsName() {
    return contactsName;
  }
  
  public void setContactsName(String contactsName) {
    this.contactsName = contactsName;
  }
  
  public String getContactsPhone() {
    return contactsPhone;
  }
  
  public void setContactsPhone(String contactsPhone) {
    this.contactsPhone = contactsPhone;
  }
  
  public Integer getCarNum() {
    return carNum;
  }
  
  public void setCarNum(Integer carNum) {
    this.carNum = carNum;
  }
  
  public String getComment() {
    return comment;
  }
  
  public void setComment(String comment) {
    this.comment = comment;
  }
  
}
