package com.chenbro.deliverybarcode.mapper.base;

import com.chenbro.deliverybarcode.model.Box;
import com.chenbro.deliverybarcode.model.User;

import java.util.List;

public interface BaseMapper<T> {



    /**
    * @Description //TODO  通過uuid 查詢
    * @Date 2020/2/26 16:33
    * @return T
    **/
    public T findByUUid(String uuid);

    /**
    * @Description //TODO  刪除
    * @Date 2020/2/26 16:33
    * @return void
    **/
    public void deleteById(String uuid);

    /**
    * @Description //TODO 修改
    * @Date 2020/2/26 16:32
    * @return void
    **/
    public void update(T t);

    /**
    * @Description //TODO  新增
    * @Date 2020/2/26 16:32
    * @return void
    **/
    public void insert(T t);


}
