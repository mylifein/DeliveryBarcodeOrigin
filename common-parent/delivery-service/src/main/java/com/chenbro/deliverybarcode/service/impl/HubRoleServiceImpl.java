package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.mapper.HubRoleMapper;
import com.chenbro.deliverybarcode.model.*;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.IHubPermissionService;
import com.chenbro.deliverybarcode.service.IHubRoleService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.BeanMapUtils;
import com.chenbro.deliverybarcode.utils.ConstantsUtil;
import com.chenbro.deliverybarcode.utils.DateUtils;
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
public class HubRoleServiceImpl extends BaseServiceImpl<HubRole> implements IHubRoleService {

    @Override
    public HubRole findByUUid(String uuid) {
        HubRole hubRole =hubRoleMapper.findByUUid(uuid);
        return hubRole;
    }



    @Override
    public void deleteById(String uuid){
        HubRole hubRole = hubRoleMapper.findByUUid(uuid);
        if(hubRole != null){
            HubRole delHubRole = new HubRole();
            //3.将hubPermission 标记成删除
            delHubRole.setUuid(hubRole.getUuid());
            delHubRole.setDelFlag("1");
            hubRoleMapper.update(delHubRole);
        }
    }

    @Override
    public List<HubRole> findAll() {
        return hubRoleMapper.findAll();
    }

    @Override
    public List<HubRole> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return hubRoleMapper.findAll();
    }

    @Override
    public void update(HubRole hubRole) {
        HubRole byUUid = hubRoleMapper.findByUUid(hubRole.getUuid());
        if(byUUid != null){
            hubRoleMapper.update(hubRole);
        }
    }

    @Override
    public void insert(HubRole hubRole) {
        String uuid = UuidUtils.getUUID();
        hubRole.setUuid(uuid);
        hubRole.setCreateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
        hubRoleMapper.insert(hubRole);
    }

    @Override
    public void assignPerms(String roleId, List<String> permIds) {
        //1.根据角色id 查询角色
        HubRole hubRole = hubRoleMapper.findByUUid(roleId);
        Set<HubPermission> perms = new HashSet<>();
        if(hubRole != null){
            //2.查询权限信息
            for(String permId : permIds){
                HubPermission hubPermission = hubPermissionMapper.findByUUid(permId);
                if(hubPermission != null){
                    //根据父Id和类型查询API权限列表
//                    List<HubPermission> apiList = hubPermissionMapper.findByTypeAndPid(ConstantsUtil.PY_API, hubPermission.getParentId());
//                    perms.addAll(apiList);
                    perms.add(hubPermission);       //当前菜单或按钮的权限
                }
            }
            for(HubPermission setPermission : perms){
                //3.分配权限
                String uuid = UuidUtils.getUUID();
                String username = "kervin";
                hubRoleMapper.assignRolePerm(hubRole,setPermission,uuid,username,DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
            }
        }
    }

    @Override
    public List<HubRole> findAllUnion() {
        return hubRoleMapper.findAllUnion();
    }
}
