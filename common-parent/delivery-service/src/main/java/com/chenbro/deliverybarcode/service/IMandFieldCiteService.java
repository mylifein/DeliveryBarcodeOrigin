package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.MandFieldCite;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface IMandFieldCiteService extends IBaseService<MandFieldCite> {

    List<MandFieldCite> findAll(int pageNum, int pageSize, String delMatno);

}
