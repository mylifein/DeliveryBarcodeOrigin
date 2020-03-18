package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

/**
 * @ClassName HubResources
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/11 14:28
 * @Version 1.0
 **/
public class HubResources extends BaseEntity {

    private String resKey;
    private String resValue;
    private Integer sortNum;


    public String getResKey() {
        return resKey;
    }

    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    public String getResValue() {
        return resValue;
    }

    public void setResValue(String resValue) {
        this.resValue = resValue;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}
