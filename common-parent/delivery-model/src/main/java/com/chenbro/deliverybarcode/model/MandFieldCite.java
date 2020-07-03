package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

/**
 * @ClassName MandFieldCite
 * @Description TODO
 * @Author c8777
 * @Date 2020/4/22 22:56
 * @Version 1.0
 **/
public class MandFieldCite extends BaseEntity {

    private String manNo;
    private String cusNo;
    private String delMatno;
    private String boundType;    //模板绑定类型    0：CT类型  1：装箱单累心  2：栈板类型

    public String getManNo() {
        return manNo;
    }

    public void setManNo(String manNo) {
        this.manNo = manNo;
    }

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

    public String getBoundType() {
        return boundType;
    }

    public void setBoundType(String boundType) {
        this.boundType = boundType;
    }
}
