package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.HubEmployee;
import com.chenbro.deliverybarcode.model.HubPermission;

import java.util.List;

public interface HubPermissionMapper extends BaseMapper<HubPermission> {

    List<HubPermission> findAll();

    List<HubPermission> findByTypeAndPid(Integer type, String parentId);
}
