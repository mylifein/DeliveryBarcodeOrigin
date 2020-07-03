package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

import java.util.List;

/**
 * @ClassName CheckWorkOrder
 * @Description TODO
 * @Author c8777
 * @Date 2020/5/18 20:33
 * @Version 1.0
 **/
public class CheckWorkOrder extends BaseEntity {

    private String woNo;
    private String delMatno;
    private String woQty;
    private String deptId;
    private String deptCode;
    private String classCode;
    private String completionSub;
    private String modelNo;
    private String delMatnoDesc;
    private String status;              //质检状态
    private Integer checkTimes;
    private List<CheckInfo> checkInfos;


    public String getWoNo() {
        return woNo;
    }

    public void setWoNo(String woNo) {
        this.woNo = woNo;
    }

    public String getDelMatno() {
        return delMatno;
    }

    public void setDelMatno(String delMatno) {
        this.delMatno = delMatno;
    }

    public String getWoQty() {
        return woQty;
    }

    public void setWoQty(String woQty) {
        this.woQty = woQty;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getCompletionSub() {
        return completionSub;
    }

    public void setCompletionSub(String completionSub) {
        this.completionSub = completionSub;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getDelMatnoDesc() {
        return delMatnoDesc;
    }

    public void setDelMatnoDesc(String delMatnoDesc) {
        this.delMatnoDesc = delMatnoDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCheckTimes() {
        return checkTimes;
    }

    public void setCheckTimes(Integer checkTimes) {
        this.checkTimes = checkTimes;
    }

    public List<CheckInfo> getCheckInfos() {
        return checkInfos;
    }

    public void setCheckInfos(List<CheckInfo> checkInfos) {
        this.checkInfos = checkInfos;
    }
}
