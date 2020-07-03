package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.BarcodeHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BarcodeHistoryMapper extends BaseMapper<BarcodeHistory> {

    List<BarcodeHistory> findAll(@Param("barcode") String barcode);

}
