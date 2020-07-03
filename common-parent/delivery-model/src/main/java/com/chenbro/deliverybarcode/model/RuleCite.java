package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

/**
 * @ClassName RuleCite
 * @Description TODO
 * @Author c8777
 * @Date 2020/4/3 8:44
 * @Version 1.0
 **/
public class RuleCite extends BaseEntity {

    private String cusNo;
    private String delMatno;
    private String ruleNo;
    private String boundType;           // 0：CT引用   1:Carton引用   2：Pallet引用



    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public String getDelMatno() {
        return delMatno;
    }

    public void setDelMatno(String delMatno) {
        this.delMatno = delMatno;
    }

    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getBoundType() {
        return boundType;
    }

    public void setBoundType(String boundType) {
        this.boundType = boundType;
    }
}


