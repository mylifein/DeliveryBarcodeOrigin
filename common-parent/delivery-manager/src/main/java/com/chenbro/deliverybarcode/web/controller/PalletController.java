package com.chenbro.deliverybarcode.web.controller;

import com.chenbro.deliverybarcode.model.Box;
import com.chenbro.deliverybarcode.model.Pallet;
import com.chenbro.deliverybarcode.model.base.BoxStatus;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.IPalletService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName PalletController
 * @Description TODO
 * @Author c8777
 * @Date 2020/6/10 10:14
 * @Version 1.0
 **/
@Controller
@RequestMapping("pallet")
public class PalletController {

    @Autowired
    private IPalletService palletService;



    @RequestMapping("query")
    public String queryBox(Model model, @RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum, @RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize,@RequestParam(name = "cusNo",required = false) String cusNo){
        List<Pallet> pallets = palletService.findAll(pageNum,pageSize,cusNo);
        PageInfo pageInfo = new PageInfo(pallets);
        model.addAttribute("pageInfo",pageInfo);
        return "box/palletQuery";
    }


    @RequestMapping("queryDetail")
    @ResponseBody
    public Result queryDetail(String uuid){
        Pallet pallet = palletService.findDetailById(uuid);
        return new Result(ResultCode.SUCCESS,pallet);
    }
}
