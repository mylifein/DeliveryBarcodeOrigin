package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

/**
 * @ClassName ProduceLine
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 10:09
 * @Version 1.0
 **/
public class ProduceLine extends BaseEntity {

    private String prodLineId;
    private String proLineName;
    private String prodLineDesc;
    private String depId;
    private String deptName;

    public String getProdLineId() {
        return prodLineId;
    }

    public void setProdLineId(String prodLineId) {
        this.prodLineId = prodLineId;
    }

    public String getProLineName() {
        return proLineName;
    }

    public void setProLineName(String proLineName) {
        this.proLineName = proLineName;
    }

    public String getProdLineDesc() {
        return prodLineDesc;
    }

    public void setProdLineDesc(String prodLineDesc) {
        this.prodLineDesc = prodLineDesc;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
