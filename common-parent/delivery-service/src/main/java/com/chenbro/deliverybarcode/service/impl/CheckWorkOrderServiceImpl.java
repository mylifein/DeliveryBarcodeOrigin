package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.CheckQueryCond;
import com.chenbro.deliverybarcode.model.CheckWorkOrder;
import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.response.CheckReportResult;
import com.chenbro.deliverybarcode.service.ICheckWorkOrderService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName CheckWorkOrderServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/5/19 9:46
 * @Version 1.0
 **/
@Service
@Transactional
public class CheckWorkOrderServiceImpl extends BaseServiceImpl<CheckWorkOrder> implements ICheckWorkOrderService {


    @Override
    public List<CheckWorkOrder> findAll(int pageNum, int pageSize, String woNo) {
        PageHelper.startPage(pageNum,pageSize);
        return checkWorkOrderMapper.findAll(woNo);
    }

    @Override
    public CheckWorkOrder queryDetailById(String uuid) {
        return checkWorkOrderMapper.findDetailById(uuid);
    }

    @Override
    public CheckWorkOrder findByUUid(String uuid) {
        return null;
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(CheckWorkOrder checkWorkOrder) {

    }

    @Override
    public void insert(CheckWorkOrder checkWorkOrder) {

    }


    @Override
    public List<CheckReportResult> queryReportByCond(CheckQueryCond checkQueryCond) {
        return checkWorkOrderMapper.queryReportByCond(checkQueryCond);
    }
}
