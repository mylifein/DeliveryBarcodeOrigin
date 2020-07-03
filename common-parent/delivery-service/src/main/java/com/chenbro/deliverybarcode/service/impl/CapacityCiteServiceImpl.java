package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.CapacityCite;
import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.service.ICapacityCiteService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName CapacityCiteServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/4/1 14:37
 * @Version 1.0
 **/
@Service
@Transactional
public class CapacityCiteServiceImpl extends BaseServiceImpl<CapacityCite> implements ICapacityCiteService {


    @Override
    public List<CapacityCite> findAll(int pageNum, int pageSize, String delMatno) {
        PageHelper.startPage(pageNum,pageSize);
        return capacityCiteMapper.findAll(delMatno);
    }

    @Override
    public CapacityCite findByUUid(String uuid) {
        return capacityCiteMapper.findByUUid(uuid);
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(CapacityCite capacityCite) {
        capacityCite.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
        capacityCiteMapper.update(capacityCite);
    }

    @Override
    public void insert(CapacityCite capacityCite) {

    }
}
