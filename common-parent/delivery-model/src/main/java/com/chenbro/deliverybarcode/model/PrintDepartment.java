package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

import java.util.List;

/**
 * @ClassName PrintDepartment
 * @Description TODO
 * @Author c8777
 * @Date 2020/4/28 10:38
 * @Version 1.0
 **/
public class PrintDepartment extends BaseEntity {

    private String deptId;
    private String deptName;
    private String deptDesc;
    private List<ProduceLine> produceLines;


    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }

    public List<ProduceLine> getProduceLines() {
        return produceLines;
    }

    public void setProduceLines(List<ProduceLine> produceLines) {
        this.produceLines = produceLines;
    }
}
