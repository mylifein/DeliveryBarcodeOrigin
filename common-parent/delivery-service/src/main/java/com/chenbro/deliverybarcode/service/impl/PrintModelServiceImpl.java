package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.PrintModel;
import com.chenbro.deliverybarcode.service.IPrintModelService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.service.base.IBaseService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class PrintModelServiceImpl extends BaseServiceImpl<PrintModel> implements IPrintModelService {

    @Override
    public List<PrintModel> findAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return printModelMapper.findAll();
    }

    @Override
    public PrintModel findByUUid(String uuid) {
        return printModelMapper.findByUUid(uuid);
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(PrintModel printModel) {

    }

    @Override
    public void insert(PrintModel printModel) {

    }

    @Override
    public PrintModel findByFileNo(String fileNo) {
        return printModelMapper.findByFileNo(fileNo);
    }
}
