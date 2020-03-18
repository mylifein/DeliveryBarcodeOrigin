package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

import java.util.List;

/**
 * @ClassName HubDepartment
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/26 16:25
 * @Version 1.0
 **/
public class HubDepartment extends BaseEntity {

    private String parentId;
    private String deptName;
    private String deptCode;
    private String category;
    private String managerId;
    private String city;
    private String introduce;
    private String manager;
    private List<HubUser> users;



    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<HubUser> getUsers() {
        return users;
    }

    public void setUsers(List<HubUser> users) {
        this.users = users;
    }
}
