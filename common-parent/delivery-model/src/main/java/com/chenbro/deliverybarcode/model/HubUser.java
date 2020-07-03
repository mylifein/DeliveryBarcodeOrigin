package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName HubUser
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/28 0:02
 * @Version 1.0
 **/
public class HubUser extends BaseEntity {

    private String username;
    private String password;
    private String enableState;        //启用状态  0是禁用，1是启用
    private Set<HubRole> roles = new HashSet<>();          //用户角色 多对多
    private String workNumber;
    private String email;
    private String mobile;
    private String gender;              //0:女性 1:男性
    private String departmentId;        //部门Id
    private String departmentName;      //部门名称
    private HubDepartment hubDepartment;    //部门信息
    private String staffPhoto;              //用戶头像

    public HubUser() {
    }

    public HubUser(Object[] values) {
        //数组格式：  用户名 ，工号，邮箱，手机号，是否启用，部门编码，性别
        super();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnableState() {
        return enableState;
    }

    public void setEnableState(String enableState) {
        this.enableState = enableState;
    }

    public Set<HubRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<HubRole> roles) {
        this.roles = roles;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public HubDepartment getHubDepartment() {
        return hubDepartment;
    }

    public void setHubDepartment(HubDepartment hubDepartment) {
        this.hubDepartment = hubDepartment;
    }


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getStaffPhoto() {
        return staffPhoto;
    }

    public void setStaffPhoto(String staffPhoto) {
        this.staffPhoto = staffPhoto;
    }
}
