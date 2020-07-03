package com.chenbro.deliverybarcode.web.controller;

import com.chenbro.deliverybarcode.model.PrintDepartment;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.IPrintDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName PrintDepartmentController
 * @Description TODO
 * @Author c8777
 * @Date 2020/5/1 10:58
 * @Version 1.0
 **/
@Controller
@RequestMapping("printDept")
public class PrintDepartmentController {

    @Autowired
    private IPrintDepartmentService printDepartmentService;

    @RequestMapping("query")
    @ResponseBody
    public Result queryAll(){
        List<PrintDepartment> printDepartments = printDepartmentService.findAllDetail();
        return new Result(ResultCode.SUCCESS,printDepartments);
    }

}
