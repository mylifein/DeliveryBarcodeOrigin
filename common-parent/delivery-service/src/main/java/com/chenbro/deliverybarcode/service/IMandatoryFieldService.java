package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.MandatoryField;
import com.chenbro.deliverybarcode.service.base.IBaseService;


import java.util.List;

public interface IMandatoryFieldService extends IBaseService<MandatoryField> {

    List<MandatoryField> findAll(int pageNum, int pageSize);

    MandatoryField findDetailByUUId(String uuid);


    MandatoryField findDetailByManNo(String manNo);
}
