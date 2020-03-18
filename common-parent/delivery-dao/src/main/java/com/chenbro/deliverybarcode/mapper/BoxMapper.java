package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.Box;
import com.chenbro.deliverybarcode.model.InspurPallet;

import java.util.List;

/**
 * @ClassName BoxMapper
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 10:34
 * @Version 1.0
 **/
public interface BoxMapper extends BaseMapper<Box> {

    void updateStatus(Box box);

    List<Box> findBoxsByPalletNo(String palletNo);

    List<Box> findBoxsByStatus(String status);

    public Box findById(String id);

    Integer findQtysByStatus(String status);

    List<InspurPallet> findAllInspurPallet();
}
