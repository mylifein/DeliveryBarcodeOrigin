package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.CapacityCite;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface ICapacityCiteService extends IBaseService<CapacityCite> {

    List<CapacityCite> findAll(int pageNum, int pageSize, String delMatno);

}
