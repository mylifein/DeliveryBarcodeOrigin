package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.mapper.HubPermissionMapper;
import com.chenbro.deliverybarcode.model.*;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.IHubPermissionService;
import com.chenbro.deliverybarcode.service.IHubUserService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.BeanMapUtils;
import com.chenbro.deliverybarcode.utils.ConstantsUtil;
import com.chenbro.deliverybarcode.utils.DateUtils;
import com.chenbro.deliverybarcode.utils.UuidUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Permission;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HubDepartmentServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/26 20:05
 * @Version 1.0
 **/
@Service
@Transactional
public class HubPermissionServiceImpl extends BaseServiceImpl<HubPermission> implements IHubPermissionService {

    @Override
    public HubPermission findByUUid(String uuid) {
        HubPermission hubPermission = hubPermissionMapper.findByUUid(uuid);
        return hubPermission;
    }

    public Map<String, Object> findByAPIId(String uuid) throws CommonException {
        HubPermission hubPermission = hubPermissionMapper.findByUUid(uuid);
        int type = hubPermission.getType();
        Object object = null;
        switch (type){
            case ConstantsUtil.PY_MENU:
                object = hubPermissionMenuMapper.findByUUid(uuid);
                break;
            case ConstantsUtil.PY_POINT:
                object = hubPermissionPointMapper.findByUUid(uuid);
                break;
            case ConstantsUtil.PY_API:
                object = hubPermissionApiMapper.findByUUid(uuid);
                break;
            default:
                throw new CommonException(ResultCode.FAIL);
        }
        Map<String, Object> map = BeanMapUtils.beanToMap(object);
        map.put("name",hubPermission.getName());
        map.put("type",hubPermission.getType());
        map.put("code",hubPermission.getCode());
        map.put("description",hubPermission.getDescription());
        map.put("parentId",hubPermission.getParentId());
        return map;
    }

    @Override
    public void deleteById(String uuid) throws CommonException {
        HubPermission hubPermission = hubPermissionMapper.findByUUid(uuid);
        if(hubPermission != null){
            //2.根据类型构造不同的资源对象 并标记删除(菜单、按钮、api)
            int type = hubPermission.getType();
            switch (type){
                case ConstantsUtil.PY_MENU:
                    HubPermissionMenu hubPermissionMenu = new HubPermissionMenu();
                    hubPermissionMenu.setUuid(uuid);
                    hubPermissionMenu.setDelFlag("1");
                    hubPermissionMenuMapper.update(hubPermissionMenu);
                    break;
                case ConstantsUtil.PY_POINT:
                    HubPermissionPoint hubPermissionPoint = new HubPermissionPoint();
                    hubPermissionPoint.setUuid(uuid);
                    hubPermissionPoint.setDelFlag("1");
                    hubPermissionPointMapper.update(hubPermissionPoint);
                    break;
                case ConstantsUtil.PY_API:
                    HubPermissionApi hubPermissionApi = new HubPermissionApi();
                    hubPermissionApi.setUuid(uuid);
                    hubPermissionApi.setDelFlag("1");
                    hubPermissionApiMapper.update(hubPermissionApi);
                    break;
                default:
                    throw new CommonException(ResultCode.FAIL);
            }
            //3.将hubPermission 标记成删除
            hubPermission.setDelFlag("1");
            hubPermissionMapper.update(hubPermission);
        }
    }

    @Override
    public void update(HubPermission hubPermission) {
//        1.根据id查询部门
        HubPermission permission = hubPermissionMapper.findByUUid(hubPermission.getUuid());
        //2.设置部门属性
        if(permission != null) {
            //3.更新部门
            hubPermissionMapper.update(permission);
        }
    }

    @Override
    public void insert(HubPermission hubPermission) {

        //设置主键的值
//        String uuid = UuidUtils.getUUID();
//        hubUser.setUuid(uuid);
//        hubUserMapper.insert(hubUser);
    }

    @Override
    public List<HubPermission> findAll() {
        return hubPermissionMapper.findAll();
    }

    @Override
    public void save(Map<String, Object> map,String username) throws Exception {
        //设置主键
        String uuid = UuidUtils.getUUID();
        //1.通过Map构造permission对象
        HubPermission hubPermission = BeanMapUtils.mapToBean(map,HubPermission.class);
        hubPermission.setUuid(uuid);
        hubPermission.setCreateBy(username);
        hubPermission.setCreateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
        //2.根据类型构造不同的资源对象(菜单、按钮、api)
        int type = hubPermission.getType();
        switch (type){
            case ConstantsUtil.PY_MENU:
                HubPermissionMenu hubPermissionMenu = BeanMapUtils.mapToBean(map,HubPermissionMenu.class);
                hubPermissionMenu.setUuid(uuid);
                hubPermissionMenu.setCreateBy(username);
                hubPermissionMenu.setCreateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
                hubPermissionMenuMapper.insert(hubPermissionMenu);
                break;
            case ConstantsUtil.PY_POINT:
                HubPermissionPoint hubPermissionPoint = BeanMapUtils.mapToBean(map,HubPermissionPoint.class);
                hubPermissionPoint.setUuid(uuid);
                hubPermissionPoint.setCreateBy(username);
                hubPermissionPoint.setCreateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
                hubPermissionPointMapper.insert(hubPermissionPoint);
                break;
            case ConstantsUtil.PY_API:
                HubPermissionApi hubPermissionApi = BeanMapUtils.mapToBean(map,HubPermissionApi.class);
                hubPermissionApi.setUuid(uuid);
                hubPermissionApi.setCreateBy(username);
                hubPermissionApi.setCreateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
                hubPermissionApiMapper.insert(hubPermissionApi);
                break;
            default:
                throw new CommonException(ResultCode.FAIL);
        }
        //3.保存
        hubPermissionMapper.insert(hubPermission);
    }



    @Override
    public void updateByMap(Map<String, Object> map) throws Exception {
        //1.通过传递的权限Id查询权限
        HubPermission hubPermission = BeanMapUtils.mapToBean(map,HubPermission.class);
        HubPermissionMenu byUUid = hubPermissionMenuMapper.findByUUid(hubPermission.getUuid());
        if(byUUid != null){     //检查更新的权限是否存在
            //2.根据类型构造不同的资源对象(菜单、按钮、api)
            int type = hubPermission.getType();
            switch (type){
                case ConstantsUtil.PY_MENU:
                    HubPermissionMenu hubPermissionMenu = BeanMapUtils.mapToBean(map,HubPermissionMenu.class);
                    hubPermissionMenu.setUuid(hubPermission.getUuid());
                    hubPermissionMenuMapper.update(hubPermissionMenu);
                    break;
                case ConstantsUtil.PY_POINT:
                    HubPermissionPoint hubPermissionPoint = BeanMapUtils.mapToBean(map,HubPermissionPoint.class);
                    hubPermissionPoint.setUuid(hubPermission.getUuid());
                    hubPermissionPointMapper.update(hubPermissionPoint);
                    break;
                case ConstantsUtil.PY_API:
                    HubPermissionApi hubPermissionApi = BeanMapUtils.mapToBean(map,HubPermissionApi.class);
                    hubPermissionApi.setUuid(hubPermission.getUuid());
                    hubPermissionApiMapper.update(hubPermissionApi);
                    break;
                default:
                    throw new CommonException(ResultCode.FAIL);
            }
            //3.保存
            hubPermissionMapper.update(hubPermission);
        }

    }
}
