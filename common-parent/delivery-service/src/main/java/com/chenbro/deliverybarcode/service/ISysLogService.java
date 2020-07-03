package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.SysLog;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface ISysLogService extends IBaseService<SysLog> {

    List<SysLog> findAll(int pageNum, int pageSize);
}
