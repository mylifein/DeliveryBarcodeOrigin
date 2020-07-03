package com.chenbro.deliverybarcode.web.controller;

import com.chenbro.deliverybarcode.model.MandFieldCite;
import com.chenbro.deliverybarcode.model.MandatoryField;
import com.chenbro.deliverybarcode.model.ModelCite;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.IMandFieldCiteService;
import com.chenbro.deliverybarcode.service.IMandatoryFieldService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName MandatoryFieldController
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/25 16:43
 * @Version 1.0
 **/
@Controller
@RequestMapping("field")
public class MandatoryFieldController {

    @Autowired
    private IMandatoryFieldService mandatoryFieldService;

    @Autowired
    private IMandFieldCiteService mandFieldCiteService;

    @RequestMapping("query")
    public String query(Model model, @RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum, @RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize){
        List<MandatoryField> mandatoryFields = mandatoryFieldService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(mandatoryFields);
        model.addAttribute("pageInfo",pageInfo);
        return "field/query";
    }

    @RequestMapping("queryDetail")
    @ResponseBody
    public Result queryDetail(String uuid){
        MandatoryField mandatoryField = mandatoryFieldService.findDetailByUUId(uuid);
        return new Result(ResultCode.SUCCESS,mandatoryField);
    }


    @RequestMapping("queryDetailByNo")
    @ResponseBody
    public Result queryDetailByNo(String manNo){
        MandatoryField mandatoryField = mandatoryFieldService.findDetailByManNo(manNo);
        return new Result(ResultCode.SUCCESS,mandatoryField);
    }


    @RequestMapping("queryCite")
    public String queryMandCite(Model model, @RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum, @RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize,@RequestParam(name = "delMatno",required = false)String delMatno){
        List<MandFieldCite> mandFieldCites = mandFieldCiteService.findAll(pageNum,pageSize,delMatno);
        PageInfo pageInfo = new PageInfo(mandFieldCites);
        model.addAttribute("pageInfo",pageInfo);
        return "field/queryCite";
    }


    @RequestMapping("queryCiteById")
    @ResponseBody
    public Result queryCiteById(String uuid){
        MandFieldCite mandFieldCite = mandFieldCiteService.findByUUid(uuid);
        return new Result(ResultCode.SUCCESS,mandFieldCite);
    }

    @RequestMapping("updateFieldCite")
    @ResponseBody
    public Result updateMandFieldCite(MandFieldCite mandFieldCite){
        mandFieldCiteService.update(mandFieldCite);
        return new Result(ResultCode.SUCCESS);
    }
}
