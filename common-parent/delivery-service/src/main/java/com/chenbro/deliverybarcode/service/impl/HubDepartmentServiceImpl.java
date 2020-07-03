package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.HubDepartment;
import com.chenbro.deliverybarcode.model.base.Node;
import com.chenbro.deliverybarcode.service.IHubDepartmentService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.UuidUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HubDepartmentServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/26 20:05
 * @Version 1.0
 **/
@Service
@Transactional
public class HubDepartmentServiceImpl extends BaseServiceImpl<HubDepartment> implements IHubDepartmentService {

    @Override
    public HubDepartment findByUUid(String uuid) {
        return hubDepartmentMapper.findByUUid(uuid);
    }

    @Override
    public void deleteById(String uuid) {
        HubDepartment hubDepartment = hubDepartmentMapper.findByUUid(uuid);
        if(hubDepartment != null){
            hubDepartment.setDelFlag("1");
            hubDepartmentMapper.update(hubDepartment);
        }
    }

    @Override
    public void update(HubDepartment hubDepartment) {
        //1.根据id查询部门
        HubDepartment department = hubDepartmentMapper.findByUUid(hubDepartment.getUuid());
        //2.设置部门属性
        department.setDeptCode(hubDepartment.getDeptCode());
        department.setDeptName(hubDepartment.getDeptName());
        department.setIntroduce(hubDepartment.getIntroduce());
        //3.更新部门
        hubDepartmentMapper.update(department);

    }

    @Override
    public void insert(HubDepartment hubDepartment) {
        //设置主键的值
        String uuid = UuidUtils.getUUID();
        hubDepartment.setUuid(uuid);
        hubDepartmentMapper.insert(hubDepartment);
    }

    @Override
    public List<HubDepartment> findAll() {
        return hubDepartmentMapper.findAll();
    }


    @Override
    public List<Node> findDeparmentTreeNode() {
        //1.查询所有部门
        List<HubDepartment> hubDepartmentList = hubDepartmentMapper.findAll();
        //2.将hubDeparmentList 转换成NodeList
        List<Node> nodes = new ArrayList<>();
        for(HubDepartment department : hubDepartmentList){
            Node node = new Node();
            node.setId(department.getUuid());
            node.setText(department.getDeptName());
            node.setpId(department.getParentId());
            nodes.add(node);
        }

        return nodes;
    }
}
