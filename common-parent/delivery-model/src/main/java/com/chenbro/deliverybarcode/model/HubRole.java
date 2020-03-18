package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName HubRole
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/28 0:11
 * @Version 1.0
 **/
public class HubRole extends BaseEntity {

    private String name;
    private String description;

    private Set<HubPermission> permissions = new HashSet<>();



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

    public Set<HubPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<HubPermission> permissions) {
        this.permissions = permissions;
    }
}
