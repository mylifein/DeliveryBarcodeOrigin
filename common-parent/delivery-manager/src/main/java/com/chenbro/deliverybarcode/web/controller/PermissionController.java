package com.chenbro.deliverybarcode.web.controller;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.HubPermission;
import com.chenbro.deliverybarcode.model.HubUser;
import com.chenbro.deliverybarcode.model.base.Node;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.IHubPermissionService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PermissionController
 * @Description TODO
 * @Author c8777
 * @Date 2020/4/9 11:54
 * @Version 1.0
 **/
@Controller
@RequestMapping("perm")
public class PermissionController {


    @Autowired
    private IHubPermissionService hubPermissionService;

    @RequestMapping("query")
    public String queryPerms(){
        return "perm/permissionQuery";
    }


    @RequestMapping("nodes")
    @ResponseBody
    public Result queryPermsNode(){
        List<HubPermission> hubPermissions = hubPermissionService.findAll();
        return new Result(ResultCode.SUCCESS,hubPermissions);
    }


    @RequestMapping("node")
    @ResponseBody
    public Result queryPermById(String uuid){
        HubPermission hubPermission = hubPermissionService.findByUUid(uuid);
        return new Result(ResultCode.SUCCESS,hubPermission);
    }

    @RequestMapping("add")
    @ResponseBody
    public Result addPerm(@RequestParam Map<String,Object> map) throws Exception {
        Object type = map.get("type");
        if(type != null){
            Integer intType = Integer.parseInt(type.toString());
            map.put("type",intType);
        }
        HubUser opUser = (HubUser) SecurityUtils.getSubject().getPrincipal();
        hubPermissionService.save(map,opUser.getUsername());
        List<HubPermission> hubPermissions = hubPermissionService.findAll();
        return new Result(ResultCode.SUCCESS,hubPermissions);
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result deletePerm(String id) throws CommonException {
        hubPermissionService.deleteById(id);
        List<HubPermission> hubPermissions = hubPermissionService.findAll();
        return new Result(ResultCode.SUCCESS,hubPermissions);
    }
}
