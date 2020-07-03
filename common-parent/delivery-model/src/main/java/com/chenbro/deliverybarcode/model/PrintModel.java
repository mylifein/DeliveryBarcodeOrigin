package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

import java.sql.Blob;

/**
 * @ClassName PrintModel
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/24 14:20
 * @Version 1.0
 **/
public class PrintModel extends BaseEntity {

    private String fileNo;
    private String fileName;
    private String fileDescription;
    private byte[] fileAddress;
    private MandatoryField mandatoryField;

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public byte[] getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(byte[] fileAddress) {
        this.fileAddress = fileAddress;
    }

    public MandatoryField getMandatoryField() {
        return mandatoryField;
    }

    public void setMandatoryField(MandatoryField mandatoryField) {
        this.mandatoryField = mandatoryField;
    }
}
