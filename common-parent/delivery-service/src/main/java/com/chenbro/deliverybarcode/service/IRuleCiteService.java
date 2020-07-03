package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.RuleCite;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface IRuleCiteService extends IBaseService<RuleCite> {

    List<RuleCite> findAll(int pageNum, int pageSize, String delMatno);

    RuleCite findDetailByUuid(String uuid);
}
