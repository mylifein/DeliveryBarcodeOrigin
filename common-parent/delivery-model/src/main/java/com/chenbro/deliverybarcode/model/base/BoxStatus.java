package com.chenbro.deliverybarcode.model.base;

public enum BoxStatus {


    PACK("0"),
    PALLET("1"),
    RECEIVE("2"),
    SHIPPING("3");

    private String value;

    private BoxStatus (String num){
        this.value = num;
    }

    public String getValue(){
        return value;
    }


}
