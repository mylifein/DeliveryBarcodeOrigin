package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.HubPermission;
import com.chenbro.deliverybarcode.model.HubUser;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.security.Permission;
import java.util.List;
import java.util.Map;

public interface IHubPermissionService extends IBaseService<HubPermission> {

    List<HubPermission> findAll();

    void save(Map<String,Object> map) throws Exception;

    void updateByMap(Map<String,Object> map) throws Exception;

    Map<String, Object> findByAPIId(String uuid) throws CommonException;
}
