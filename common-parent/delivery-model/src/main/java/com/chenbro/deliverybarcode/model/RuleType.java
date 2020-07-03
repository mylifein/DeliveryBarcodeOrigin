package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

/**
 * @ClassName RuleType
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/27 14:19
 * @Version 1.0
 **/
public class RuleType extends BaseEntity {

    private String typeNo;
    private String typeDesc;

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
}
