package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

import java.lang.reflect.Field;

/**
 * @ClassName FieldType
 * @Description TODO  字段类型
 * @Author c8777
 * @Date 2020/3/25 11:51
 * @Version 1.0
 **/
public class FieldType extends BaseEntity {

    private String fieldNo;
    private String fieldName;
    private String fieldValue;
    private String fieldDesc;


    public String getFieldNo() {
        return fieldNo;
    }

    public void setFieldNo(String fieldNo) {
        this.fieldNo = fieldNo;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }
}
