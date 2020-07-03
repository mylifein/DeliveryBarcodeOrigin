package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

import java.util.Date;

/**
 * @ClassName BarcodeHistory
 * @Description TODO
 * @Author c8777
 * @Date 2020/7/2 9:54
 * @Version 1.0
 **/
public class BarcodeHistory extends BaseEntity {

    private String barcode;
    private String actType;             //狀態
    private String barcodeType;         //條碼類型
    private Date startTime;            //狀態開始時間
    private Date endTime;
    private Integer duration;


    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
    }

    public String getBarcodeType() {
        return barcodeType;
    }

    public void setBarcodeType(String barcodeType) {
        this.barcodeType = barcodeType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
