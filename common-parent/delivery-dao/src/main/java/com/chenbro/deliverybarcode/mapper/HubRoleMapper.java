package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.HubPermission;
import com.chenbro.deliverybarcode.model.HubRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HubRoleMapper extends BaseMapper<HubRole> {

    List<HubRole> findAll();

    void assignRolePerm(@Param("role") HubRole hubRole, @Param("permission") HubPermission hubPermission, @Param("id") String id, @Param("createBy") String createBy, @Param("createDate") String createDate);

    List<HubRole> findAllUnion();
}
