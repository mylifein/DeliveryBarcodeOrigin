package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.SysLog;
import com.chenbro.deliverybarcode.service.ISysLogService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName SysLogServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/5/20 10:23
 * @Version 1.0
 **/
@Service
@Transactional
public class SysLogServiceImpl extends BaseServiceImpl<SysLog> implements ISysLogService {



    @Override
    public List<SysLog> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return sysLogMapper.findAll();
    }

    @Override
    public SysLog findByUUid(String uuid) {
        return null;
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(SysLog sysLog) {

    }

    @Override
    public void insert(SysLog sysLog) {
        sysLogMapper.insert(sysLog);
    }
}
