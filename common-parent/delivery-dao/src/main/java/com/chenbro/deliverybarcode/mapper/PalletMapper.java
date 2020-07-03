package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.Box;
import com.chenbro.deliverybarcode.model.Pallet;
import com.chenbro.deliverybarcode.model.PalletQueryCond;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BoxMapper
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 10:34
 * @Version 1.0
 **/
public interface PalletMapper extends BaseMapper<Pallet> {


    public Pallet findById(String id);

    List<Pallet> findAll(@Param("cusNo") String cusNo);

    Pallet findDetailById(@Param("uuid")String uuid);

    List<Pallet> queryPalletReportByCond(PalletQueryCond palletQueryCond);


}
