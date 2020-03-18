package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.HubDepartment;
import com.chenbro.deliverybarcode.model.base.Node;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface IHubDepartmentService extends IBaseService<HubDepartment> {

    List<HubDepartment> findAll();

    List<Node> findDeparmentTreeNode();
}
