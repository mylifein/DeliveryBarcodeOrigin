package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.BarcodeHistory;
import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.service.IBarcodeHistoryService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName BarcodeHistoryServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/7/2 13:18
 * @Version 1.0
 **/
@Service
@Transactional
public class BarcodeHistoryServiceImpl extends BaseServiceImpl<BarcodeHistory> implements IBarcodeHistoryService {



    @Override
    public BarcodeHistory findById(String id) {
        return barcodeHistoryMapper.findByUUid(id);
    }

    @Override
    public List<BarcodeHistory> findAll(Integer pageNum, Integer pageSize, String barcode) {
        PageHelper.startPage(pageNum,pageSize);
        return barcodeHistoryMapper.findAll(barcode);
    }

    @Override
    public BarcodeHistory findByUUid(String uuid) {
        return null;
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(BarcodeHistory barcodeHistory) {

    }

    @Override
    public void insert(BarcodeHistory barcodeHistory) {

    }
}
