package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.HubPermission;
import com.chenbro.deliverybarcode.model.HubPermissionApi;

import java.util.List;

public interface HubPermissionApiMapper extends BaseMapper<HubPermissionApi> {

    List<HubPermissionApi> findAll();

}
