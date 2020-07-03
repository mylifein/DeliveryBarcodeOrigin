package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.PrintModel;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface IPrintModelService extends IBaseService<PrintModel> {

    List<PrintModel> findAll(int pageNum,int pageSize);


    PrintModel findByFileNo(String fileNo);
}
