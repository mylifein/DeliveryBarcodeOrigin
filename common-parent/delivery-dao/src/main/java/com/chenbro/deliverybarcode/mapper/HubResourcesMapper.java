package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.HubPermission;
import com.chenbro.deliverybarcode.model.HubResources;
import com.chenbro.deliverybarcode.model.HubRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HubResourcesMapper extends BaseMapper<HubResources> {

    List<HubResources> findAllAsc();


}
