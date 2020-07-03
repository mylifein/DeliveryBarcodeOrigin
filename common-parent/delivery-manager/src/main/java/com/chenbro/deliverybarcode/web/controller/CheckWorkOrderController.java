package com.chenbro.deliverybarcode.web.controller;

import com.chenbro.deliverybarcode.model.CheckWorkOrder;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.ICheckWorkOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName CheckOrderController
 * @Description TODO
 * @Author c8777
 * @Date 2020/5/19 10:09
 * @Version 1.0
 **/
@Controller
@RequestMapping("checkOrder")
public class CheckWorkOrderController {

    @Autowired
    private ICheckWorkOrderService checkWorkOrderService;

    @RequestMapping("query")
    public String queryAll(Model model, @RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum, @RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize,@RequestParam(name = "woNo",required = false)String woNo){
        List<CheckWorkOrder> checkWorkOrders = checkWorkOrderService.findAll(pageNum,pageSize,woNo);
        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(checkWorkOrders);
        model.addAttribute("pageInfo",pageInfo);
        return "checkOrder/checkWorkOrder";
    }



    @RequestMapping("queryDetail")
    @ResponseBody
    public Result queryDetail(String uuid){
        CheckWorkOrder checkWorkOrder = checkWorkOrderService.queryDetailById(uuid);
        return new Result(ResultCode.SUCCESS,checkWorkOrder);
    }
}
