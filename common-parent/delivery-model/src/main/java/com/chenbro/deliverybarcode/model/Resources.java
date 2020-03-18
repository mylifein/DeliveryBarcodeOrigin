package com.chenbro.deliverybarcode.model;


import com.chenbro.deliverybarcode.model.base.BaseEntity;

import java.io.Serializable;

public class Resources extends BaseEntity {


    private String resId;
    private String resKey;
    private String resValue;
    private Integer sortNum;

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

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
