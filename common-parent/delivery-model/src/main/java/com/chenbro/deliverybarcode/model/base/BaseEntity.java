package com.chenbro.deliverybarcode.model.base;

import java.io.Serializable;
import java.sql.Timestamp;

public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -4980624821355502318L;

    /**
     * 删除标记(0：正常；1：删除；2：审核)
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";


    /**
     * 实体编号(唯一标识)
     */
    protected String uuid;


    /**
     * 创建者
     */
    protected String createBy;

    /**
     * 创建日期
     */
    protected String createDate;

    /**
     * 更新者
     */
    protected  String updateBy;

    /**
     * 更新日期
     */
    protected  String updateDate;

    /**
     * 删除标识
     */
    protected  String delFlag;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
