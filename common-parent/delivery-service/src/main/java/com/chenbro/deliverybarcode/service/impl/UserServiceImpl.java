package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.HubDepartment;
import com.chenbro.deliverybarcode.model.User;
import com.chenbro.deliverybarcode.service.IUserService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/11 14:24
 * @Version 1.0
 **/
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {


    @Override
    public User login(String username, String password) {
        return null;
    }


    @Override
    public void deleteById(String uuid) {
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void insert(User user) {

    }

    @Override
    public User findByUUid(String uuid) {
        return userMapper.findByUUid(uuid);
    }

    @Override
    public Set<String> selectRolesAllUserName() {
        return null;
    }

    @Override
    public Set<String> selectRolesByUserName(String username) {
        return null;
    }
}
