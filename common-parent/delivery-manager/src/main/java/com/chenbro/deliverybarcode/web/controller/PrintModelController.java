package com.chenbro.deliverybarcode.web.controller;

import com.chenbro.deliverybarcode.model.*;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.*;
import com.chenbro.deliverybarcode.utils.DownloadUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @ClassName PrintModelController
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/25 9:12
 * @Version 1.0
 **/
@Controller
@RequestMapping("print")
public class PrintModelController {

    @Autowired
    private IPrintModelService printModelService;

    @Autowired
    private IModelCiteService modelCiteService;

    @Autowired
    private IFieldTypeService fieldTypeService;

    @Autowired
    private ICodeRuleService codeRuleService;

    @Autowired
    private DownloadUtils downloadUtils;

    @Autowired
    private ICapacityService capacityService;

    @Autowired
    private ICapacityCiteService capacityCiteService;

    @RequestMapping("query")
    public String query(Model model, @RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum, @RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize){
        List<PrintModel> printModels = printModelService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(printModels);
        model.addAttribute("pageInfo",pageInfo);
        return "print/query";
    }

    @RequestMapping("queryModel")
    @ResponseBody
    public Result queryModelById(String fileNo){
        PrintModel printModel = printModelService.findByFileNo(fileNo);
        return new Result(ResultCode.SUCCESS,printModel);
    }

    @RequestMapping("queryCite")
    public String queryCite(Model model, @RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum, @RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize,@RequestParam(name = "delMatno",required = false)String delMatno){
        List<ModelCite> modelCites = modelCiteService.findAll(pageNum, pageSize,delMatno);
        PageInfo pageInfo = new PageInfo(modelCites);
        model.addAttribute("pageInfo",pageInfo);
        return "print/queryCite";
    }

    @RequestMapping("queryCiteDetail")
    @ResponseBody
    public Result queryCiteById(String uuid){
        ModelCite modelCite = modelCiteService.findByUUid(uuid);
        return new Result(ResultCode.SUCCESS,modelCite);
    }

    @RequestMapping("updateModelCite")
    @ResponseBody
    public Result updateModelCite(ModelCite modelCite){
        modelCiteService.update(modelCite);
        return new Result(ResultCode.SUCCESS,modelCite);
    }

    @RequestMapping("queryField")
    public String queryField(Model model, @RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum, @RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize){
        List<FieldType> fieldTypes = fieldTypeService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(fieldTypes);
        model.addAttribute("pageInfo",pageInfo);
        return "print/queryField";
    }


    @RequestMapping("download")
    public void downloadModel(String uuid, HttpServletResponse response) throws IOException {
        PrintModel detailByUuid = printModelService.findByUUid(uuid);
        byte[] resource = detailByUuid.getFileAddress();
        response.setContentType("application/octet-stream");
        String fileName = response.encodeURL(new String(detailByUuid.getFileName().getBytes(), "iso8859-1"));        //保存的文件名，必须和页面编码一致
        response.addHeader("Content-disposition", "attachment;filename="+fileName);
        response.setContentLength(resource.length);
        ServletOutputStream outputStream = response.getOutputStream();      //取得输出流
        outputStream.write(resource);
        outputStream.flush();                                       //刷新
        response.setContentType("multipart/form-data");
    }


    @RequestMapping("queryCapacity")
    public String queryCapacity(Model model, @RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum, @RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize){
        List<Capacity> capacities = capacityService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(capacities);
        model.addAttribute("pageInfo",pageInfo);
        return "print/queryCapacity";
    }

    @RequestMapping("queryCapacityCite")
    public String queryCapacityCite(Model model, @RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum, @RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize,@RequestParam(name = "delMatno",required = false)String delMatno){
        List<CapacityCite> capacityCites = capacityCiteService.findAll(pageNum, pageSize,delMatno);
        PageInfo pageInfo = new PageInfo(capacityCites);
        model.addAttribute("pageInfo",pageInfo);
        return "print/queryCapacityCite";
    }

    @RequestMapping("queryCapacityByNo")
    @ResponseBody
    public Result queryCapacityByNo(String capacityNo){
        Capacity capacity = capacityService.findCapacityByNo(capacityNo);
        return new Result(ResultCode.SUCCESS,capacity);
    }



    @RequestMapping("updateCapacityCite")
    @ResponseBody
    public Result updateMandFieldCite(CapacityCite capacityCite){
        capacityCiteService.update(capacityCite);
        return new Result(ResultCode.SUCCESS);
    }

    @RequestMapping("queryCapacityCiteById")
    @ResponseBody
    public Result queryCapacityCiteById(String uuid){
        CapacityCite capacityCite = capacityCiteService.findByUUid(uuid);
        return new Result(ResultCode.SUCCESS,capacityCite);
    }
}
