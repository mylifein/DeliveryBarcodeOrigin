package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

/**
 * @ClassName CapacityCite
 * @Description TODO
 * @Author c8777
 * @Date 2020/4/1 14:02
 * @Version 1.0
 **/
public class CapacityCite extends BaseEntity {

    private String capacityNo;
    private String cusNo;
    private String delMatno;
    private String capacityType;

    public String getCapacityNo() {
        return capacityNo;
    }

    public void setCapacityNo(String capacityNo) {
        this.capacityNo = capacityNo;
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

    public String getCapacityType() {
        return capacityType;
    }

    public void setCapacityType(String capacityType) {
        this.capacityType = capacityType;
    }
}
