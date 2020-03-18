package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.Pallet;
import com.chenbro.deliverybarcode.service.base.IBaseService;

public interface IPalletService extends IBaseService<Pallet> {

    public Pallet findById(String id);
}
