package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.MandatoryField;
import com.chenbro.deliverybarcode.service.IMandatoryFieldService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName MandatoryFieldServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/25 14:24
 * @Version 1.0
 **/
@Service
@Transactional
public class MandatoryFieldServiceImpl extends BaseServiceImpl<MandatoryField> implements IMandatoryFieldService {


    @Override
    public List<MandatoryField> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return mandatoryFieldMapper.findAll();
    }

    @Override
    public MandatoryField findDetailByUUId(String uuid) {
        return mandatoryFieldMapper.findDetailByUUId(uuid);
    }


    @Override
    public MandatoryField findDetailByManNo(String manNo) {
        return mandatoryFieldMapper.findDetailByManNo(manNo);
    }

    @Override
    public MandatoryField findByUUid(String uuid) {
        return null;
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(MandatoryField mandatoryField) {
        mandatoryField.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public void insert(MandatoryField mandatoryField) {

    }
}
