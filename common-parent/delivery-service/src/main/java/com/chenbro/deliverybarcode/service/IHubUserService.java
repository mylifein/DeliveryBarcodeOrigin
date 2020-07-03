package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.HubDepartment;
import com.chenbro.deliverybarcode.model.HubUser;
import com.chenbro.deliverybarcode.service.base.IBaseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IHubUserService extends IBaseService<HubUser> {

    List<HubUser> findAll(int pageNum,int pageSize);

    void assignRoles(String userId, List<String> roleIds);

    HubUser findByUsername(String username);

    HubUser findUnionByUUid(String uuid);

    String uploadImage(String id, MultipartFile file) throws IOException;
}
