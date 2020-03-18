package com.chenbro.deliverybarcode.model.response;

import com.chenbro.deliverybarcode.model.HubPermission;
import com.chenbro.deliverybarcode.model.HubRole;
import com.chenbro.deliverybarcode.model.HubUser;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ProfileResult
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/3 23:02
 * @Version 1.0
 **/
public class ProfileResult implements Serializable {
    private static final long serialVersionUID = -7486444877894517267L;

    private String mobile;
    private String username;
    private Map<String,Object> roles = new HashMap<>();

    public ProfileResult(HubUser hubUser) {
        this.mobile = hubUser.getMobile();
        this.username = hubUser.getUsername();
        Set<HubRole> roles = hubUser.getRoles();
        Set<String> menus = new HashSet<>();
        Set<String> apis = new HashSet<>();
        Set<String> points = new HashSet<>();
        for(HubRole hubRole : roles){
            Set<HubPermission> permissions = hubRole.getPermissions();
            for(HubPermission hubPermission : permissions){
                String code = hubPermission.getCode();
                if(hubPermission.getType() == 1){
                    menus.add(code);
                }else if(hubPermission.getType() == 2) {
                    points.add(code);
                }else{
                    apis.add(code);
                }
            }
        }
        this.roles.put("menus",menus);
        this.roles.put("apis",apis);
        this.roles.put("points",points);
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, Object> getRoles() {
        return roles;
    }

    public void setRoles(Map<String, Object> roles) {
        this.roles = roles;
    }
}
