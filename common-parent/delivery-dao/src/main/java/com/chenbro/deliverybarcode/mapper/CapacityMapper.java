package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.Capacity;
import com.chenbro.deliverybarcode.model.ModelCite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName CapacityMapper
 * @Description TODO
 * @Author c8777
 * @Date 2020/4/1 10:34
 * @Version 1.0
 **/
public interface CapacityMapper extends BaseMapper<Capacity> {


    List<Capacity> findAll();


    Capacity findCapacityByNo(@Param("capacityNo") String capacityNo);
}
