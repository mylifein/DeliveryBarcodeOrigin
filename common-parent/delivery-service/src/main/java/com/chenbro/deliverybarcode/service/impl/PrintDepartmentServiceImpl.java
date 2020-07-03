package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.PrintDepartment;
import com.chenbro.deliverybarcode.service.IPrintDepartmentService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName PrintDepartmentServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/5/1 9:56
 * @Version 1.0
 **/
@Service
@Transactional
public class PrintDepartmentServiceImpl extends BaseServiceImpl<PrintDepartment> implements IPrintDepartmentService {

    @Override
    public List<PrintDepartment> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return printDepartmentMapper.findAll();
    }

    @Override
    public PrintDepartment findDetailByUuid(String uuid) {
        return printDepartmentMapper.findDetailByUuid(uuid);
    }

    @Override
    public List<PrintDepartment> findAllDetail() {
        return printDepartmentMapper.findAllDetail();
    }

    @Override
    public PrintDepartment findByUUid(String uuid) {
        return null;
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(PrintDepartment printDepartment) {

    }

    @Override
    public void insert(PrintDepartment printDepartment) {

    }
}
