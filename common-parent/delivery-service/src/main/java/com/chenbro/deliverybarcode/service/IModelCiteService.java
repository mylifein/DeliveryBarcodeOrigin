package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.ModelCite;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface IModelCiteService extends IBaseService<ModelCite> {

    List<ModelCite> findAll(int pageNum, int pageSize, String delMatno);

    ModelCite findDetailByUuid(String uuid);
}
