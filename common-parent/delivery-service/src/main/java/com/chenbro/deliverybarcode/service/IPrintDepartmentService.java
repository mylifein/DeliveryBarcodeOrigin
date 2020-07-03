package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.PrintDepartment;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface IPrintDepartmentService extends IBaseService<PrintDepartment> {

    List<PrintDepartment> findAll(int pageNum, int pageSize);

    PrintDepartment findDetailByUuid(String uuid);


    List<PrintDepartment> findAllDetail();
}
