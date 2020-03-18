package com.chenbro.deliverybarcode.api.controller;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.HubDepartment;
import com.chenbro.deliverybarcode.model.HubPermission;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.IHubDepartmentService;
import com.chenbro.deliverybarcode.service.IHubPermissionService;
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
public class HubPermissionController {

    @Autowired
    IHubPermissionService hubPermissionService;

    @RequestMapping(value = "/permission",method = RequestMethod.GET)
    public Result findAllDepartment(){
        List<HubPermission> hubPermissionList = hubPermissionService.findAll();
        return new Result(ResultCode.SUCCESS,hubPermissionList);
    }

    @RequestMapping(value = "/permission/{id}",method = RequestMethod.GET)
    public Result findDepartmentById(@PathVariable(value = "id")String uuid) throws CommonException {
        Map<String, Object> map = hubPermissionService.findByAPIId(uuid);
        return new Result(ResultCode.SUCCESS,map);
    }


    @RequestMapping(value = "/permission",method = RequestMethod.POST)
    public Result addDepartment(@RequestBody Map<String,Object> map) throws Exception {
        hubPermissionService.save(map);
        return new Result(ResultCode.SUCCESS);
    }


    @RequestMapping(value = "/permission/{id}",method = RequestMethod.DELETE)
    public Result deleteDepartment(@PathVariable(value = "id") String uuid) throws CommonException {
        hubPermissionService.deleteById(uuid);
        return new Result(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/permission/{id}",method = RequestMethod.PUT)
    public Result updateDepartment(@PathVariable(value = "id") String uuid,@RequestBody Map<String,Object> map) throws Exception {
        map.put("uuid",uuid);
        hubPermissionService.updateByMap(map);
        return new Result(ResultCode.SUCCESS);
    }
}
