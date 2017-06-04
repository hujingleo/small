package com.ptteng.small.model;

/**
 * 用作统计每个库位各有多少车辆
 * @author huangchao
 *
 */
public class JsonModel {
    private String type;
    private String value;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
