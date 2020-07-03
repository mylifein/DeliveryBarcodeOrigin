package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.BarcodeHistory;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface IBarcodeHistoryService extends IBaseService<BarcodeHistory> {

    BarcodeHistory findById(String id);


    List<BarcodeHistory> findAll(Integer pageNum, Integer pageSize, String barcode);


}
