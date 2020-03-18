package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.HubPermissionApi;
import com.chenbro.deliverybarcode.model.HubPermissionMenu;

import java.util.List;

public interface HubPermissionMenuMapper extends BaseMapper<HubPermissionMenu> {

    List<HubPermissionMenu> findAll();

}
