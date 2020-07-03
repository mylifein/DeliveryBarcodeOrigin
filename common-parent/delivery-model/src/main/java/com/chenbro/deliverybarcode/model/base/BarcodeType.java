package com.chenbro.deliverybarcode.model.base;

public enum BarcodeType {
    CT("CT"),                     // CT條碼
    BOX("BOX"),                   // 箱號條碼
    PALLET("PALLET");                // 棧板條碼
    private String barcodeType;

    public String getBarcodeType() {
        return barcodeType;
    }

    public void setBarcodeType(String barcodeType) {
        this.barcodeType = barcodeType;
    }

    BarcodeType(String barcodeType){
        this.barcodeType = barcodeType;
    }
}
