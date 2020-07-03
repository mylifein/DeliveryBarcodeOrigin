package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.Ctcode;
import com.chenbro.deliverybarcode.service.ICtcodeService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName CtcodeServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/20 9:08
 * @Version 1.0
 **/
@Service
@Transactional
public class CtcodeServiceImpl extends BaseServiceImpl<Ctcode> implements ICtcodeService {


    @Override
    public List<Ctcode> findAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return ctcodeMapper.findAll();
    }

    @Override
    public Ctcode findByUUid(String uuid) {
        return null;
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(Ctcode ctcode) {

    }

    @Override
    public void insert(Ctcode ctcode) {

    }
}
