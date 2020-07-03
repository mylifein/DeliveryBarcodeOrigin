package com.chenbro.deliverybarcode.service.impl;


import com.chenbro.deliverybarcode.model.Capacity;
import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.service.ICapacityService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName CapacityServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/4/1 13:44
 * @Version 1.0
 **/
@Service
@Transactional
public class CapacityServiceImpl extends BaseServiceImpl<Capacity> implements ICapacityService {


    @Override
    public List<Capacity> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return capacityMapper.findAll();
    }

    @Override
    public Capacity findByUUid(String uuid) {
        return null;
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(Capacity capacity) {

    }

    @Override
    public void insert(Capacity capacity) {

    }

    @Override
    public Capacity findCapacityByNo(String capacityNo) {
        return capacityMapper.findCapacityByNo(capacityNo);
    }
}
