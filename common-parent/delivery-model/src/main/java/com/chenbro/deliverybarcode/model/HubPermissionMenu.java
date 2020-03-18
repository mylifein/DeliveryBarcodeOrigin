package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

/**
 * @ClassName HubPermissionMenu
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/28 11:41
 * @Version 1.0
 **/
public class HubPermissionMenu extends BaseEntity {

    private String menuIcon;    //展示图标
    private String menuOrder;   //排序号

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }
}
