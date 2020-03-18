package com.chenbro.deliverybarcode.web.controller;

import com.chenbro.deliverybarcode.model.Box;
import com.chenbro.deliverybarcode.model.HubUser;
import com.chenbro.deliverybarcode.model.InspurPallet;
import com.chenbro.deliverybarcode.model.base.BoxStatus;
import com.chenbro.deliverybarcode.service.IBoxService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName BoxController
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/14 12:40
 * @Version 1.0
 **/
@Controller
@RequestMapping("box")
public class BoxController {

    @Autowired
    private IBoxService boxService;


    @RequestMapping("query")
    public String queryBox(Model model){
        List<Box> boxList = boxService.findAll();
        Integer pickedQty = boxService.findQtysByStatus(BoxStatus.PACK.getValue());
        Integer packedQty = boxService.findQtysByStatus(BoxStatus.PALLET.getValue());
        Integer receivedQty = boxService.findQtysByStatus(BoxStatus.RECEIVE.getValue());
        Integer shippedQty = boxService.findQtysByStatus(BoxStatus.SHIPPING.getValue());
        model.addAttribute("boxes",boxList);
        model.addAttribute("pickedQty",pickedQty);
        model.addAttribute("packedQty",packedQty);
        model.addAttribute("receivedQty",receivedQty);
        model.addAttribute("shippedQty",shippedQty);
        return "box/query";
    }


    @RequestMapping("queryInspur")
    public String queryInspur(Model model, @RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum, @RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize){
        List<InspurPallet> inspurPallets = boxService.findAllInspurPallet(pageNum,pageSize);
        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(inspurPallets);
        model.addAttribute("pageInfo",pageInfo);
        return "box/inspurQuery";
    }



}
