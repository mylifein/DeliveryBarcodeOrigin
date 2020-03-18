package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

/**
 * @ClassName HubPermissionApi
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/28 10:29
 * @Version 1.0
 **/
public class HubPermissionApi extends BaseEntity {

    private String apiUrl;          //链接
    private String apiMethod;       //請求類型
    private String apiLevel;        //权限等级， 1为通用接口权限， 2为需校验接口权限



}
