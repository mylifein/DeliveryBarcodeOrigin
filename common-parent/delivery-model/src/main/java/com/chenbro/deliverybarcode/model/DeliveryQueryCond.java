package com.chenbro.deliverybarcode.model;

import java.io.Serializable;

/**
 * @ClassName DeliveryQueryCond
 * @Description TODO
 * @Author c8777
 * @Date 2020/5/3 23:55
 * @Version 1.0
 **/
public class DeliveryQueryCond implements Serializable {


    private static final long serialVersionUID = -4827703875607439118L;
    private String dept;
    private String prodLine;
    private String status;
    private String workNo;
    private String delMatno;
    private String cusMatno;
    private String soOrder;
    private String cusPO;
    private String packType;
    private String createdStartTime;
    private String createdEndTime;
    private String updatedStartTime;
    private String updatedEndTime;


    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getProdLine() {
        return prodLine;
    }

    public void setProdLine(String prodLine) {
        this.prodLine = prodLine;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public String getDelMatno() {
        return delMatno;
    }

    public void setDelMatno(String delMatno) {
        this.delMatno = delMatno;
    }

    public String getCusMatno() {
        return cusMatno;
    }

    public void setCusMatno(String cusMatno) {
        this.cusMatno = cusMatno;
    }

    public String getSoOrder() {
        return soOrder;
    }

    public void setSoOrder(String soOrder) {
        this.soOrder = soOrder;
    }

    public String getCusPO() {
        return cusPO;
    }

    public void setCusPO(String cusPO) {
        this.cusPO = cusPO;
    }

    public String getPackType() {
        return packType;
    }

    public void setPackType(String packType) {
        this.packType = packType;
    }

    public String getCreatedStartTime() {
        return createdStartTime;
    }

    public void setCreatedStartTime(String createdStartTime) {
        this.createdStartTime = createdStartTime;
    }

    public String getCreatedEndTime() {
        return createdEndTime;
    }

    public void setCreatedEndTime(String createdEndTime) {
        this.createdEndTime = createdEndTime;
    }

    public String getUpdatedStartTime() {
        return updatedStartTime;
    }

    public void setUpdatedStartTime(String updatedStartTime) {
        this.updatedStartTime = updatedStartTime;
    }

    public String getUpdatedEndTime() {
        return updatedEndTime;
    }

    public void setUpdatedEndTime(String updatedEndTime) {
        this.updatedEndTime = updatedEndTime;
    }
}
