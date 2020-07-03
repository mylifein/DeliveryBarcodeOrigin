package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

/**
 * @ClassName ModelCite
 * @Description TODO  打印模板与客户编号和出货料号的关系
 * @Author c8777
 * @Date 2020/3/26 17:47
 * @Version 1.0
 **/
public class ModelCite extends BaseEntity {

    private String fileNo;
    private String cusNo;
    private String delMatno;
    private String boundType;    //模板绑定类型    0：CT类型  1：装箱单累心  2：栈板类型

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public String getDelMatno() {
        return delMatno;
    }

    public void setDelMatno(String delMatno) {
        this.delMatno = delMatno;
    }

    public String getBoundType() {
        return boundType;
    }

    public void setBoundType(String boundType) {
        this.boundType = boundType;
    }
}
