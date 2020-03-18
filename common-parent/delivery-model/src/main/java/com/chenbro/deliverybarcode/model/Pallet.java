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
}
