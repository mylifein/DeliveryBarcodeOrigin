package com.chenbro.deliverybarcode.model.response;

import com.chenbro.deliverybarcode.model.HubPermission;
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
public class HubRoleResult implements Serializable {


    private static final long serialVersionUID = 2205268362213685808L;

    private String uuid;
    private String createBy;
    private String createDate;
    private  String updateBy;
    private  String updateDate;
    private String name;
    private String description;
    private List<String> permIds = new ArrayList<>();

    public HubRoleResult(HubRole hubRole){
        if(hubRole != null){
            BeanUtils.copyProperties(hubRole,this);
            for(HubPermission hubPermission : hubRole.getPermissions()){
                this.permIds.add(hubPermission.getUuid());
            }
        }
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPermIds() {
        return permIds;
    }

    public void setPermIds(List<String> permIds) {
        this.permIds = permIds;
    }
}
