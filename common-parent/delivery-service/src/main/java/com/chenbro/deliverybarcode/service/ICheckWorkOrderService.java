package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.CheckQueryCond;
import com.chenbro.deliverybarcode.model.CheckWorkOrder;
import com.chenbro.deliverybarcode.model.response.CheckReportResult;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface ICheckWorkOrderService extends IBaseService<CheckWorkOrder> {

    List<CheckWorkOrder> findAll(int pageNum,int pageSize,String woNo);


    CheckWorkOrder queryDetailById(String uuid);


    List<CheckReportResult> queryReportByCond(CheckQueryCond checkQueryCond);

}
