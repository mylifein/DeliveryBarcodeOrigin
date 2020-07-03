package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.HubDepartment;
import com.chenbro.deliverybarcode.model.HubRole;
import com.chenbro.deliverybarcode.model.HubUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface HubUserMapper extends BaseMapper<HubUser> {

    List<HubUser> findAll();

    void assignUserRole(@Param("user") HubUser user, @Param("role") HubRole role, @Param("id") String id, @Param("createBy") String createBy, @Param("createDate") String createDate);

    HubUser findByUsername(@Param("username") String username);

    HubUser findUnionByUUid(@Param("uuid") String uuid);
}
