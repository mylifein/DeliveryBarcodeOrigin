package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.WoBatch;
import com.chenbro.deliverybarcode.service.IWoBatchService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName WoBatchServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/5/6 16:59
 * @Version 1.0
 **/
@Service
@Transactional
public class WoBatchServiceImpl extends BaseServiceImpl<WoBatch> implements IWoBatchService {


    @Override
    public List<WoBatch> findAll(int pageNum, int pageSize, String woNo) {
        PageHelper.startPage(pageNum,pageSize);
        return woBatchMapper.findAll(woNo);
    }

    @Override
    public WoBatch findByUUid(String uuid) {
        return woBatchMapper.findByUUid(uuid);
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(WoBatch woBatch) {
        woBatch.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
        woBatchMapper.update(woBatch);
    }

    @Override
    public void insert(WoBatch woBatch) {

    }
}
