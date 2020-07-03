package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.Capacity;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface ICapacityService extends IBaseService<Capacity> {

    List<Capacity> findAll(int pageNum, int pageSize);

    Capacity findCapacityByNo(String capacityNo);
}
