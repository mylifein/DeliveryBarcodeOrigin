package com.chenbro.deliverybarcode.web.controller;

import com.chenbro.deliverybarcode.model.SysLog;
import com.chenbro.deliverybarcode.service.ISysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName SysLogController
 * @Description TODO
 * @Author c8777
 * @Date 2020/5/21 8:08
 * @Version 1.0
 **/
@Controller
@RequestMapping("sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("query")
    public String querySysLogs(Model model, @RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum, @RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize){
        List<SysLog> sysLogs = sysLogService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(sysLogs);
        model.addAttribute("pageInfo",pageInfo);
        return "log/syslog";
    }


}
