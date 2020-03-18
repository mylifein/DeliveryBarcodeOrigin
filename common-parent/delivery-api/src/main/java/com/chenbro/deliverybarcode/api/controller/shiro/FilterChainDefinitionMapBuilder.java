package com.chenbro.deliverybarcode.api.controller.shiro;


import com.chenbro.deliverybarcode.model.HubResources;
import com.chenbro.deliverybarcode.model.Resources;
import com.chenbro.deliverybarcode.service.IHubResourcesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FilterChainDefinitionMapBuilder {

    @Autowired
    private IHubResourcesService hubResourcesService;


    public Map<String,String> builder(){
        Map<String,String> map = new LinkedHashMap<String, String>();
        List<HubResources> resourcesList = hubResourcesService.selectAllSortAsc();
        for(HubResources resources : resourcesList){
            map.put(resources.getResKey(),resources.getResValue());
        }
        return map;
    }

    /**
     *  资源表 resources
     *  主键ID, key，val,sort number,status
     */


}
