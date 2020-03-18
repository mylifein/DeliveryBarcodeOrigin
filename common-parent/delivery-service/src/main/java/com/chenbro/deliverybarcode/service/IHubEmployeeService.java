package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.HubEmployee;
import com.chenbro.deliverybarcode.model.HubUser;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface IHubEmployeeService extends IBaseService<HubEmployee> {

    List<HubEmployee> findAll();
}
