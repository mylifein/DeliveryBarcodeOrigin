package com.chenbro.deliverybarcode.api.controller;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.HubDepartment;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.IHubDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName DepartmentController
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/27 17:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("hub")
public class HubDepartmentController {

    @Autowired
    IHubDepartmentService hubDepartmentService;

    @RequestMapping(value = "/department",method = RequestMethod.GET)
    public Result findAllDepartment(){
        List<HubDepartment> departmentList = hubDepartmentService.findAll();
        return new Result(ResultCode.SUCCESS,departmentList);
    }

    @RequestMapping(value = "/department/{id}",method = RequestMethod.GET)
    public Result findDepartmentById(@PathVariable(value = "id")String uuid) throws CommonException {
        HubDepartment hubDepartment = hubDepartmentService.findByUUid(uuid);
        return new Result(ResultCode.SUCCESS,hubDepartment);
    }


    @RequestMapping(value = "/department",method = RequestMethod.POST)
    public Result addDepartment(@RequestBody(required = false) HubDepartment hubDepartment){
        hubDepartmentService.insert(hubDepartment);
        return new Result(ResultCode.SUCCESS);
    }


    @RequestMapping(value = "/department/{id}",method = RequestMethod.DELETE)
    public Result deleteDepartment(@PathVariable(value = "id") String uuid) throws CommonException {
        hubDepartmentService.deleteById(uuid);
        return new Result(ResultCode.SUCCESS);
    }
}
