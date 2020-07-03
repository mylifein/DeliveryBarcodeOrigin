package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.SysLog;

import java.util.List;

public interface SysLogMapper extends BaseMapper<SysLog> {

    List<SysLog> findAll();

}
