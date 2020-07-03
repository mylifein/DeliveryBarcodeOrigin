package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

import java.util.List;

/**
 * @ClassName MandatoryField
 * @Description TODO  打印模板参数字段
 * @Author c8777
 * @Date 2020/3/25 11:49
 * @Version 1.0
 **/
public class MandatoryField extends BaseEntity {

    private String manNo;
    private String manDesc;
    private List<FieldType> fieldTypes;


    public String getManNo() {
        return manNo;
    }

    public void setManNo(String manNo) {
        this.manNo = manNo;
    }

    public String getManDesc() {
        return manDesc;
    }

    public void setManDesc(String manDesc) {
        this.manDesc = manDesc;
    }

    public List<FieldType> getFieldTypes() {
        return fieldTypes;
    }

    public void setFieldTypes(List<FieldType> fieldTypes) {
        this.fieldTypes = fieldTypes;
    }
}
