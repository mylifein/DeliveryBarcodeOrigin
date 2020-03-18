package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.Box;
import com.chenbro.deliverybarcode.model.InspurPallet;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface IBoxService extends IBaseService<Box> {



    Result receive(String cartonNo);

    Result shipping(String id);

    /**
    * @Description //TODO 查詢所有 倉庫收貨狀態的 裝箱單
    * @Date 2020/2/19 20:42
    * @return java.util.List<com.chenbro.deliverybarcode.model.Box>
    **/
    List<Box> findAllReceive();

    /**
    * @Description //TODO 查詢所有出貨狀態的 裝箱單
    * @Date 2020/2/19 20:42
    * @return java.util.List<com.chenbro.deliverybarcode.model.Box>
    **/
    List<Box> findAllShipping();

    Result findReiveById(String id);

    /**
    * @Description //TODO  查询所有装箱单
    * @Date 2020/3/12 18:13
    * @return java.util.List<com.chenbro.deliverybarcode.model.Box>
    **/
    List<Box> findAll();

    /**
    * @Description //TODO  根据装箱单状态查询数量
    * @Date 2020/3/12 23:32
    * @return java.lang.Integer
    **/
    Integer findQtysByStatus(String status);


    /**
    * @Description //TODO  查询原浪潮出货信息
    * @Date 2020/3/17 14:44
    * @return java.util.List<com.chenbro.deliverybarcode.model.InspurPallet>
    **/
    List<InspurPallet> findAllInspurPallet(int pageNum,int pageSize);
}
