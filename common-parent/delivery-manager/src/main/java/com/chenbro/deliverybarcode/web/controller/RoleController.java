package com.chenbro.deliverybarcode.web.controller;

import com.chenbro.deliverybarcode.model.HubRole;
import com.chenbro.deliverybarcode.model.HubUser;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.IHubRoleService;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName RoleController
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/21 0:39
 * @Version 1.0
 **/
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IHubRoleService hubRoleService;

    @RequestMapping("query")
    public String query(Model model, @RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum, @RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize){
        List<HubRole> hubRoles = hubRoleService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(hubRoles);
        model.addAttribute("pageInfo",pageInfo);
        return "role/roleQuery";
    }

    @RequestMapping("add")
    @ResponseBody
    public Result addHubRole(HubRole hubRole){
        HubUser opUser = (HubUser) SecurityUtils.getSubject().getPrincipal();
        hubRole.setCreateBy(opUser.getUsername());
        hubRoleService.insert(hubRole);
        return new Result(ResultCode.SUCCESS);
    }


    @RequestMapping("find")
    @ResponseBody
    public Result findHubRole(String uuid){
        HubRole hubRole = hubRoleService.findByUUid(uuid);
        return new Result(ResultCode.SUCCESS,hubRole);
    }



}
