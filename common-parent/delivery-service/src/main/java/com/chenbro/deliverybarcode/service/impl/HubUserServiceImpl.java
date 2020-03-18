package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.HubDepartment;
import com.chenbro.deliverybarcode.model.HubRole;
import com.chenbro.deliverybarcode.model.HubUser;
import com.chenbro.deliverybarcode.service.IHubDepartmentService;
import com.chenbro.deliverybarcode.service.IHubUserService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.UuidUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName HubDepartmentServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/26 20:05
 * @Version 1.0
 **/
@Service
@Transactional
public class HubUserServiceImpl extends BaseServiceImpl<HubUser> implements IHubUserService {

    @Override
    public HubUser findByUUid(String uuid) {
        return hubUserMapper.findByUUid(uuid);
    }

    @Override
    public void deleteById(String uuid) {
        HubUser hubUser = hubUserMapper.findByUUid(uuid);
        if(hubUser != null){
            HubUser deleteUser = new HubUser();
            deleteUser.setUuid(hubUser.getUuid());
            deleteUser.setDelFlag("1");
            hubUserMapper.update(deleteUser);
        }
    }

    @Override
    public void update(HubUser hubUser) {
        //1.根据id查询部门
        HubUser resulHhubUser = hubUserMapper.findByUUid(hubUser.getUuid());
        //2.设置部门属性
        if(resulHhubUser != null) {
            //3.更新部门
            hubUserMapper.update(hubUser);
        }
    }

    @Override
    public void insert(HubUser hubUser) {
        //设置主键的值
        String uuid = UuidUtils.getUUID();
        hubUser.setUuid(uuid);
        hubUser.setUsername(hubUser.getWorkNumber());
        hubUser.setPassword("123456");
        hubUser.setEnableState("0");
        hubUserMapper.insert(hubUser);
    }

    @Override
    public List<HubUser> findAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return hubUserMapper.findAll();
    }

    /**
    * @Description //TODO 为用户分配角色
    * @Date 2020/3/2 23:53
    * @return void
    **/
    @Override
    public void assignRoles(String userId, List<String> roleIds) {
        //1.根据id查询用户
        HubUser hubUser = hubUserMapper.findByUUid(userId);
        if(hubUser != null){
            for(String roleId : roleIds){
                HubRole hubRole = hubRoleMapper.findByUUid(roleId);
                if(hubRole != null){
                    String uuid = UuidUtils.getUUID();
                    String username = "kervin";
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                    String createDate = df.format(new Date());
                    hubUserMapper.assignUserRole(hubUser,hubRole,uuid,username,createDate);
                }
            }
        }
    }

    @Override
    public HubUser findByUsername(String username) {
        return hubUserMapper.findByUsername(username);
    }

    @Override
    public HubUser findUnionByUUid(String uuid) {
        return hubUserMapper.findUnionByUUid(uuid);
    }
}
