package com.chenbro.deliverybarcode.api.controller;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.HubPermission;
import com.chenbro.deliverybarcode.model.HubRole;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.model.response.HubRoleResult;
import com.chenbro.deliverybarcode.service.IHubPermissionService;
import com.chenbro.deliverybarcode.service.IHubRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DepartmentController
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/27 17:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("hub")
public class HubRoleController {

    @Autowired
    IHubRoleService hubRoleService;


    @RequestMapping(value = "/role/assignPerms",method = RequestMethod.PUT)
    public Result assignRolePerms(@RequestBody Map<String,Object> map) throws CommonException {
        //1.获取被分配得角色id
        String roleId = (String) map.get("id");
        //2.获取到权限的列表
        List<String> permIds = (List<String>) map.get("permIds");
        //3.调用Service完成权限分配
        hubRoleService.assignPerms(roleId,permIds);
        return new Result(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/role",method = RequestMethod.GET)
    public Result findAllDepartment(){
        List<HubRole> hubRoleList = hubRoleService.findAll();
        return new Result(ResultCode.SUCCESS,hubRoleList);
    }

    @RequestMapping(value = "/role/{id}",method = RequestMethod.GET)
    public Result findDepartmentById(@PathVariable(value = "id")String uuid) throws CommonException {
        HubRole hubRole = hubRoleService.findByUUid(uuid);
        HubRoleResult hubRoleResult = new HubRoleResult(hubRole);
        return new Result(ResultCode.SUCCESS,hubRoleResult);
    }


    @RequestMapping(value = "/role",method = RequestMethod.POST)
    public Result addDepartment(@RequestBody HubRole hubRole) throws Exception {
        hubRoleService.insert(hubRole);
        return new Result(ResultCode.SUCCESS);
    }


    @RequestMapping(value = "/role/{id}",method = RequestMethod.DELETE,name = "API-ROLE-DELETE")
    public Result deleteDepartment(@PathVariable(value = "id") String uuid) throws CommonException {
        hubRoleService.deleteById(uuid);
        return new Result(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/role",method = RequestMethod.PUT)
    public Result updateDepartment(@RequestBody HubRole hubRole) throws Exception {
        hubRoleService.update(hubRole);
        return new Result(ResultCode.SUCCESS);
    }
}
