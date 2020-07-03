package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.Pallet;
import com.chenbro.deliverybarcode.model.PalletQueryCond;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.service.base.IBaseService;


import java.util.List;

public interface IPalletService extends IBaseService<Pallet> {

    Pallet findById(String id);


    List<Pallet> findAll(Integer pageNum,Integer pageSize,String cusNo);

    Pallet findDetailById(String uuid);

    List<Pallet> queryPalletReportByCond(PalletQueryCond palletQueryCond);


    Result replyUpdate(String barcode,String statusCode);
}
