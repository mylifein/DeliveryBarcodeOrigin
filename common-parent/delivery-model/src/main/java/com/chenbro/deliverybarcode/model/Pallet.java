package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Pallet
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 8:38
 * @Version 1.0
 **/
public class Pallet extends BaseEntity {


    private String palletNo;
    private String workNo;
    private String palletQty;
    private String batchNo;
    private String capacityNo;
    private String modelNo;
    private String ruleNo;
    private String cusNo;
    private String cusName;
    private String cusPo;
    private String cusMatno;
    private String delMatno;
    private String soOrder;
    private String vehicleNo;
    private String status;
    private List<Box> boxes;


    public String getPalletNo() {
        return palletNo;
    }

    public void setPalletNo(String palletNo) {
        this.palletNo = palletNo;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public String getPalletQty() {
        return palletQty;
    }

    public void setPalletQty(String palletQty) {
        this.palletQty = palletQty;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getCapacityNo() {
        return capacityNo;
    }

    public void setCapacityNo(String capacityNo) {
        this.capacityNo = capacityNo;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPo() {
        return cusPo;
    }

    public void setCusPo(String cusPo) {
        this.cusPo = cusPo;
    }

    public String getCusMatno() {
        return cusMatno;
    }

    public void setCusMatno(String cusMatno) {
        this.cusMatno = cusMatno;
    }

    public String getDelMatno() {
        return delMatno;
    }

    public void setDelMatno(String delMatno) {
        this.delMatno = delMatno;
    }

    public String getSoOrder() {
        return soOrder;
    }

    public void setSoOrder(String soOrder) {
        this.soOrder = soOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
