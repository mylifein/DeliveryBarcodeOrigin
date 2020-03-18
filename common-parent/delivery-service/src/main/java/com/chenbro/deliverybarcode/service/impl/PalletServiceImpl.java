package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.Pallet;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.service.IPalletService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.UuidUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName PalletServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/19 11:54
 * @Version 1.0
 **/
@Service
public class PalletServiceImpl extends BaseServiceImpl<Pallet> implements IPalletService {

    @Override
    public Pallet findById(String id) {
        Pallet pallet = palletMapper.findById(id);
        if(pallet != null){
            pallet.setBoxes(boxMapper.findBoxsByPalletNo(id));
        }
        return pallet;
    }

    @Override
    public Pallet findByUUid(String uuid) {
        return null;
    }

    @Override
    public void deleteById(String uuid) {

    }

    @Override
    public void update(Pallet pallet) {

    }

    @Override
    public void insert(Pallet pallet) {

    }
}
