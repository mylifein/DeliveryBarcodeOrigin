package com.chenbro.deliverybarcode.web.controller;

import com.chenbro.deliverybarcode.model.Ctcode;
import com.chenbro.deliverybarcode.service.ICtcodeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName CtcodeController
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/20 9:17
 * @Version 1.0
 **/
@Controller
@RequestMapping("ct")
public class CtcodeController {

    @Autowired
    private ICtcodeService ctcodeService;

    @RequestMapping("query")
    public String queryAll(Model model, @RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum, @RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize){
        List<Ctcode> ctcodeList = ctcodeService.findAll(pageNum,pageSize);
        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(ctcodeList);
        model.addAttribute("pageInfo",pageInfo);
        return "ct/query";
    }
}
