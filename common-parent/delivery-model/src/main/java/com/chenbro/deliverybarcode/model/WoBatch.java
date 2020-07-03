package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

/**
 * @ClassName WoBatch
 * @Description TODO
 * @Author c8777
 * @Date 2020/5/5 16:15
 * @Version 1.0
 **/
public class WoBatch extends BaseEntity {

    private String workNo;
    private String batchNo;
    private String batchType;

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getBatchType() {
        return batchType;
    }

    public void setBatchType(String batchType) {
        this.batchType = batchType;
    }

}
