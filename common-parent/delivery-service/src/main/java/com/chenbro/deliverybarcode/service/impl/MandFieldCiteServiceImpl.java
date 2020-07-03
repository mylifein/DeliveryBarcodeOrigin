package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.MandFieldCite;
import com.chenbro.deliverybarcode.service.IMandFieldCiteService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName MandFieldCiteServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/4/22 23:34
 * @Version 1.0
 **/
@Service
@Transactional
public class MandFieldCiteServiceImpl extends BaseServiceImpl<MandFieldCite> implements IMandFieldCiteService {


    @Override
    public List<MandFieldCite> findAll(int pageNum, int pageSize, String delMatno) {
        PageHelper.startPage(pageNum,pageSize);
        return mandFieldCiteMapper.findAll(delMatno);
    }

    @Override
    public MandFieldCite findByUUid(String uuid) {
        return mandFieldCiteMapper.findByUUid(uuid);
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(MandFieldCite mandFieldCite) {
        mandFieldCite.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
        mandFieldCiteMapper.update(mandFieldCite);
    }

    @Override
    public void insert(MandFieldCite mandFieldCite) {

    }
}
