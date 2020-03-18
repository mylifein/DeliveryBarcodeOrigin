package com.chenbro.deliverybarcode.api.controller;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.HubEmployee;
import com.chenbro.deliverybarcode.model.HubUser;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.IHubEmployeeService;
import com.chenbro.deliverybarcode.service.IHubUserService;
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
public class HubEmployeeController {

    @Autowired
    IHubEmployeeService hubEmployeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public Result findAllUser(){
        List<HubEmployee> hubEmployees = hubEmployeeService.findAll();
        return new Result(ResultCode.SUCCESS,hubEmployees);
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public Result findUserById(@PathVariable(value = "id")String uuid) throws CommonException {
        HubEmployee hubEmployee = hubEmployeeService.findByUUid(uuid);
        return new Result(ResultCode.SUCCESS,hubEmployee);
    }


    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public Result addDepartment(@RequestBody(required = false) HubEmployee hubEmployee){
        hubEmployeeService.insert(hubEmployee);
        return new Result(ResultCode.SUCCESS);
    }


    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public Result deleteDepartment(@PathVariable(value = "id") String uuid) throws CommonException {
        hubEmployeeService.deleteById(uuid);
        return new Result(ResultCode.SUCCESS);
    }
}
