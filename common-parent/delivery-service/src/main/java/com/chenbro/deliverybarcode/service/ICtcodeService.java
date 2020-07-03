package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.Ctcode;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface ICtcodeService extends IBaseService<Ctcode> {

    List<Ctcode> findAll(int pageNum,int pageSize);
}
