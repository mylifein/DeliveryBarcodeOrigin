package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.FieldType;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface IFieldTypeService extends IBaseService<FieldType> {

    List<FieldType> findAll(int pageNum, int pageSize);

    FieldType findDetailByUuid(String uuid);
}
