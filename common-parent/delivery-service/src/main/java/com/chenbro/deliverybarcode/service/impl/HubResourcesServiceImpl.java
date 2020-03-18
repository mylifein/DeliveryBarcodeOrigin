package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.HubResources;
import com.chenbro.deliverybarcode.service.IHubResourcesService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.Subject;
import java.util.List;

@Service
@Transactional
public class HubResourcesServiceImpl extends BaseServiceImpl<HubResources> implements IHubResourcesService {


    @Override
    public List<HubResources> selectAllSortAsc() {
        return hubResourcesMapper.findAllAsc();
    }


    @Override
    public HubResources findByUUid(String uuid) {
        return hubResourcesMapper.findByUUid(uuid);
    }

    @Override
    public void deleteById(String uuid) {

    }

    @Override
    public void update(HubResources resources) {
        hubResourcesMapper.update(resources);
    }

    @Override
    public void insert(HubResources resources) {
        hubResourcesMapper.insert(resources);
    }
}
