package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.HubEmployee;
import com.chenbro.deliverybarcode.model.HubUser;
import com.chenbro.deliverybarcode.service.IHubEmployeeService;
import com.chenbro.deliverybarcode.service.IHubUserService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.UuidUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName HubDepartmentServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/26 20:05
 * @Version 1.0
 **/
@Service
@Transactional
public class HubEmployeeServiceImpl extends BaseServiceImpl<HubEmployee> implements IHubEmployeeService {

    @Override
    public HubEmployee findByUUid(String uuid) {
        return hubEmployeeMapper.findByUUid(uuid);
    }

    @Override
    public void deleteById(String uuid) {
        HubEmployee hubEmployee = hubEmployeeMapper.findByUUid(uuid);
        if(hubEmployee != null){
            hubEmployee.setDelFlag("1");
            hubEmployeeMapper.update(hubEmployee);
        }
    }

    @Override
    public void update(HubEmployee hubEmployee) {
        //1.根据id查询部门
        HubEmployee resulHubEmployee = hubEmployeeMapper.findByUUid(hubEmployee.getUuid());
        //2.设置部门属性
        if(resulHubEmployee != null) {
            //3.更新部门
            hubEmployeeMapper.update(hubEmployee);
        }
    }

    @Override
    public void insert(HubEmployee hubEmployee) {
        //设置主键的值
        String uuid = UuidUtils.getUUID();
        hubEmployee.setUuid(uuid);
        hubEmployeeMapper.insert(hubEmployee);
    }

    @Override
    public List<HubEmployee> findAll() {
        return hubEmployeeMapper.findAll();
    }
}
