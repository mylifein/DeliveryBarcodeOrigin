package com.chenbro.deliverybarcode.utils;

import com.chenbro.deliverybarcode.model.BarcodeHistory;
import com.chenbro.deliverybarcode.model.base.BarcodeType;

import java.util.Date;

/**
 * @ClassName BarcodeHistoryUtils
 * @Description TODO
 * @Author c8777
 * @Date 2020/7/2 17:08
 * @Version 1.0
 **/
public class BarcodeHistoryUtils {

    public static BarcodeHistory buildBarcodeHistory(String barcode,String statusCode,String username,BarcodeType barcodeType){
        //增加一條修改記錄
        BarcodeHistory barcodeHistory = new BarcodeHistory();
        barcodeHistory.setUuid(UuidUtils.getUUID());
        barcodeHistory.setBarcode(barcode);
        barcodeHistory.setActType(statusCode);
        barcodeHistory.setBarcodeType(barcodeType.getBarcodeType());
        barcodeHistory.setStartTime(new Date());
        barcodeHistory.setCreateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
        barcodeHistory.setCreateBy(username);
        return  barcodeHistory;
    }
}
