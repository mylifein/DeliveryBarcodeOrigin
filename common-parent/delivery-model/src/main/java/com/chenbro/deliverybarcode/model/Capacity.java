package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

/**
 * @ClassName Capacity
 * @Description TODO
 * @Author c8777
 * @Date 2020/4/1 13:33
 * @Version 1.0
 **/
public class Capacity extends BaseEntity {

    private String capacityNo;
    private Integer capacityQty;
    private String capacityDesc;

    public String getCapacityNo() {
        return capacityNo;
    }

    public void setCapacityNo(String capacityNo) {
        this.capacityNo = capacityNo;
    }

    public Integer getCapacityQty() {
        return capacityQty;
    }

    public void setCapacityQty(Integer capacityQty) {
        this.capacityQty = capacityQty;
    }

    public String getCapacityDesc() {
        return capacityDesc;
    }

    public void setCapacityDesc(String capacityDesc) {
        this.capacityDesc = capacityDesc;
    }
}
