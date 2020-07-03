package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.ModelCite;
import com.chenbro.deliverybarcode.service.IModelCiteService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName PrintModelServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/25 9:07
 * @Version 1.0
 **/
@Service
@Transactional
public class ModelCiteServiceImpl extends BaseServiceImpl<ModelCite> implements IModelCiteService {

    @Override
    public List<ModelCite> findAll(int pageNum, int pageSize, String delMatno) {
        PageHelper.startPage(pageNum,pageSize);
        return modelCiteMapper.findAll(delMatno);
    }

    @Override
    public ModelCite findByUUid(String uuid) {
        return modelCiteMapper.findByUUid(uuid);
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(ModelCite modelCite) {
        modelCite.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
        modelCiteMapper.update(modelCite);
    }

    @Override
    public void insert(ModelCite modelCite) {

    }

    @Override
    public ModelCite findDetailByUuid(String uuid) {

        return modelCiteMapper.findDetailByUuid(uuid);
    }
}
