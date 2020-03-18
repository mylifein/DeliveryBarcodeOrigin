package com.chenbro.deliverybarcode.model.response;

import com.chenbro.deliverybarcode.model.HubRole;
import com.chenbro.deliverybarcode.model.HubUser;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HubUserResult
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/3 15:22
 * @Version 1.0
 **/
public class HubUserResult implements Serializable {

    private static final long serialVersionUID = -7696094642879512168L;

    private String uuid;
    private String createBy;
    private String createDate;
    private  String updateBy;
    private  String updateDate;
    private String username;
    private String enableState;        //启用状态  0是禁用，1是启用
    private String workNumber;
    private String email;
    private String mobile;
    private String gender;              //0:女性 1:男性
    private String departmentId;        //部门Id
    private String departmentName;      //部门名称

    private List<String> roleIds = new ArrayList<>();

    public HubUserResult(HubUser hubUser){
        BeanUtils.copyProperties(hubUser,this);
        for(HubRole hubRole : hubUser.getRoles()){
            this.roleIds.add(hubRole.getUuid());
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEnableState() {
        return enableState;
    }

    public void setEnableState(String enableState) {
        this.enableState = enableState;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }
}
