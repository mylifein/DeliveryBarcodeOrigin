package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

/**
 * @ClassName Ctcode
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/20 8:05
 * @Version 1.0
 **/
public class Ctcode extends BaseEntity {

    private String ctNumber;
    private String ruleNo;
    private String workNo;
    private String cusNo;
    private String cusName;
    private String cusPo;
    private String poQty;
    private String cusMatno;
    private String delMatno;
    private String offiNo;
    private String verNo;
    private String woQuantity;
    private String modelNo;
    private String soOrder;


    public String getCtNumber() {
        return ctNumber;
    }

    public void setCtNumber(String ctNumber) {
        this.ctNumber = ctNumber;
    }

    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
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

    public String getPoQty() {
        return poQty;
    }

    public void setPoQty(String poQty) {
        this.poQty = poQty;
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


    public String getOffiNo() {
        return offiNo;
    }

    public void setOffiNo(String offiNo) {
        this.offiNo = offiNo;
    }

    public String getVerNo() {
        return verNo;
    }

    public void setVerNo(String verNo) {
        this.verNo = verNo;
    }

    public String getWoQuantity() {
        return woQuantity;
    }

    public void setWoQuantity(String woQuantity) {
        this.woQuantity = woQuantity;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getSoOrder() {
        return soOrder;
    }

    public void setSoOrder(String soOrder) {
        this.soOrder = soOrder;
    }
}
