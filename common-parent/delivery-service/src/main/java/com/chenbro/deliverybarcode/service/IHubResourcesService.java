package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.HubResources;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface IHubResourcesService extends IBaseService<HubResources> {

    /**
     * 查询所有的资源权限 状态有效，且按sortNum升序排序
     * @return
     */
    List<HubResources> selectAllSortAsc();

}
