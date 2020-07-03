package com.chenbro.deliverybarcode.model.response;

import java.io.Serializable;

/**
 * @ClassName CheckReportResult
 * @Description TODO
 * @Author c8777
 * @Date 2020/5/22 11:53
 * @Version 1.0
 **/
public class CheckReportResult implements Serializable {

    private static final long serialVersionUID = 1338742490700743651L;

    private String woNo;
    private String delMatno;
    private String woQty;
    private String deptId;
    private String deptCode;
    private String classCode;
    private String completionSub;
    private String modelNo;
    private String delMatnoDesc;
    protected String createDate;
    private String wostatus;              //质检状态
    private Integer checkTimes;
    private String qualityNo;
    private String startTime;
    private String endTime;
    private long duringTime;
    private String deliverMan;
    private String status;
    private Integer checkNum;
    private String remark;
    private String checkMan;
    private String deiliveryTime;

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getWostatus() {
        return wostatus;
    }

    public void setWostatus(String wostatus) {
        this.wostatus = wostatus;
    }

    public Integer getCheckTimes() {
        return checkTimes;
    }

    public void setCheckTimes(Integer checkTimes) {
        this.checkTimes = checkTimes;
    }

    public String getQualityNo() {
        return qualityNo;
    }

    public void setQualityNo(String qualityNo) {
        this.qualityNo = qualityNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public long getDuringTime() {
        return duringTime;
    }

    public void setDuringTime(long duringTime) {
        this.duringTime = duringTime;
    }

    public String getDeliverMan() {
        return deliverMan;
    }

    public void setDeliverMan(String deliverMan) {
        this.deliverMan = deliverMan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCheckMan() {
        return checkMan;
    }

    public void setCheckMan(String checkMan) {
        this.checkMan = checkMan;
    }

    public String getDeiliveryTime() {
        return deiliveryTime;
    }

    public void setDeiliveryTime(String deiliveryTime) {
        this.deiliveryTime = deiliveryTime;
    }

    public Integer getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(Integer checkNum) {
        this.checkNum = checkNum;
    }
}
