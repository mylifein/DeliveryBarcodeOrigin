package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.HubRole;
import com.chenbro.deliverybarcode.model.HubUser;
import com.chenbro.deliverybarcode.service.IHubUserService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.DateUtils;
import com.chenbro.deliverybarcode.utils.UuidUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;
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
        HubUser resulHhubUser = hubUserMapper.findByUsername(hubUser.getUsername());
        //2.设置部门属性
        if(resulHhubUser != null) {
            //3.更新部门
            hubUser.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
            hubUserMapper.update(hubUser);
        }
    }

    @Override
    public void insert(HubUser hubUser) {
        //设置主键的值
        hubUser.setUuid(UuidUtils.getUUID());
        hubUser.setCreateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
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
                    hubUserMapper.assignUserRole(hubUser,hubRole,uuid,username,DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
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

    /**
    * @Description //TODO  完成图片处理
    * @Date 2020/3/28 18:52
    * @return java.lang.String  请求路径
    **/
    @Override
    public String uploadImage(String id, MultipartFile file) throws IOException {
        //1.根据id查询用户
        HubUser user = hubUserMapper.findByUUid(id);
        //2.使用DataUrl的形式存储图片(对图片byte数组进行base64编码)
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = "data:image/png;base64," + base64Encoder.encode(file. getBytes());
        //3.更新用户头像地址
        user.setStaffPhoto(encode);
        //4.返回
        return encode;
    }
}
