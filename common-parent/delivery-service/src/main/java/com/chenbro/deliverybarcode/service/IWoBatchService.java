package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.WoBatch;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface IWoBatchService extends IBaseService<WoBatch> {

    List<WoBatch> findAll(int pageNum, int pageSize,String woNo);



}
