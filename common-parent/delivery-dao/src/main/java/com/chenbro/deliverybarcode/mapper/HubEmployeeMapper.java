package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.HubDepartment;
import com.chenbro.deliverybarcode.model.HubEmployee;

import java.util.List;

public interface HubEmployeeMapper extends BaseMapper<HubEmployee> {

    List<HubEmployee> findAll();

}
