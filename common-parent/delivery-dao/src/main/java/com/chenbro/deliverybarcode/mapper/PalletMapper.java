package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.Box;
import com.chenbro.deliverybarcode.model.Pallet;

/**
 * @ClassName BoxMapper
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 10:34
 * @Version 1.0
 **/
public interface PalletMapper extends BaseMapper<Pallet> {

    void updateStatus(Pallet pallet);

    public Pallet findById(String id);
}
