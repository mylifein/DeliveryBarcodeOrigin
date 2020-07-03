package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.FieldType;
import com.chenbro.deliverybarcode.service.IFieldTypeService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName FieldTypeServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/27 8:29
 * @Version 1.0
 **/
@Service
@Transactional
public class FieldTypeServiceImpl extends BaseServiceImpl<FieldType> implements IFieldTypeService {


    @Override
    public List<FieldType> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return fieldTypeMapper.findAll();
    }

    @Override
    public FieldType findDetailByUuid(String uuid) {
        return null;
    }

    @Override
    public FieldType findByUUid(String uuid) {
        return null;
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(FieldType fieldType) {

    }

    @Override
    public void insert(FieldType fieldType) {

    }
}
