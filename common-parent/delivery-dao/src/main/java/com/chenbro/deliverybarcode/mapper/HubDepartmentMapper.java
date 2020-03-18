package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.Box;
import com.chenbro.deliverybarcode.model.HubDepartment;

import java.util.List;

public interface HubDepartmentMapper extends BaseMapper<HubDepartment> {

    List<HubDepartment> findAll();

}
