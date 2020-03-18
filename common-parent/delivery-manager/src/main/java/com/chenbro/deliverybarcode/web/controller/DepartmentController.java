package com.chenbro.deliverybarcode.web.controller;

import com.chenbro.deliverybarcode.model.HubDepartment;
import com.chenbro.deliverybarcode.model.base.Node;
import com.chenbro.deliverybarcode.service.IHubDepartmentService;
import com.chenbro.deliverybarcode.utils.TreeNodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName DepartmentController
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/14 21:42
 * @Version 1.0
 **/
@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private IHubDepartmentService hubDepartmentService;

    @Autowired
    private TreeNodeBuilder treeNodeBuilder;

    @RequestMapping("deparmentTree")
    @ResponseBody
    public List<Node> getDepartmentTree(){
        List<Node> nodes = hubDepartmentService.findDeparmentTreeNode();
        List<Node> treeNodes = treeNodeBuilder.buildTree(nodes);
        return treeNodes;
    }

}
