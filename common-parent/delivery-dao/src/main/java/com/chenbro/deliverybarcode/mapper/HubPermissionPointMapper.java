package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.HubPermissionMenu;
import com.chenbro.deliverybarcode.model.HubPermissionPoint;

import java.util.List;

public interface HubPermissionPointMapper extends BaseMapper<HubPermissionPoint> {

    List<HubPermissionPoint> findAll();

}
