package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.HubPermission;
import com.chenbro.deliverybarcode.model.HubRole;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;
import java.util.Map;

public interface IHubRoleService extends IBaseService<HubRole> {

    List<HubRole> findAll();

    List<HubRole> findAll(int pageNum,int pageSize);

    void assignPerms(String roleId, List<String> permIds);

    List<HubRole> findAllUnion();
}
