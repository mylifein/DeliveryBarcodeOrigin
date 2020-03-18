package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.User;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.Set;

public interface IUserService extends IBaseService<User> {

    //特有的方法
    public User login(String username,String password);

    Set<String> selectRolesByUserName(String username);

    /**
     * 查询所有角色
     * @return
     */
    Set<String> selectRolesAllUserName();
}
