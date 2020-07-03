package com.chenbro.deliverybarcode.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName MonitorController
 * @Description TODO
 * @Author c8777
 * @Date 2020/4/8 11:59
 * @Version 1.0
 **/
@Controller
@RequestMapping("monitor")
public class MonitorController {





    @RequestMapping("assembly")
    public String transToAssemblyA(String mark){
        switch (mark){
            case "A":
                return "monitor/assemblyA";
            case "B":
                return "monitor/assemblyB";
            case "C":
                return "monitor/assemblyC";
            default:
                return "monitor/assemblyA";
        }
    }
}
