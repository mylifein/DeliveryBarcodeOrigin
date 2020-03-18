package com.chenbro.deliverybarcode.web.shiro;

import com.chenbro.deliverybarcode.model.HubResources;
import com.chenbro.deliverybarcode.service.IHubResourcesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName FilterChainDefinitionMapBuilder
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/11 0:05
 * @Version 1.0
 **/
public class FilterChainDefinitionMapBuilder {

    @Autowired
    private IHubResourcesService hubResourcesService;

    public Map<String,String> builder(){
        Map<String,String> map = new LinkedHashMap<>();
        return null;
    }
}
