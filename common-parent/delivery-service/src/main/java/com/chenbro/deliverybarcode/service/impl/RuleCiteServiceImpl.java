package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.RuleCite;
import com.chenbro.deliverybarcode.service.IRuleCiteService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName RuleCiteServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/4/5 13:14
 * @Version 1.0
 **/
@Service
@Transactional
public class RuleCiteServiceImpl extends BaseServiceImpl<RuleCite> implements IRuleCiteService {


    @Override
    public List<RuleCite> findAll(int pageNum, int pageSize, String delMatno) {
        PageHelper.startPage(pageNum,pageSize);
        return ruleCiteMapper.findAll(delMatno);
    }

    @Override
    public RuleCite findDetailByUuid(String uuid) {
        return null;
    }

    @Override
    public RuleCite findByUUid(String uuid) {
        return ruleCiteMapper.findByUUid(uuid);
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(RuleCite ruleCite) {
        ruleCite.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
         ruleCiteMapper.update(ruleCite);
    }

    @Override
    public void insert(RuleCite ruleCite) {

    }
}
