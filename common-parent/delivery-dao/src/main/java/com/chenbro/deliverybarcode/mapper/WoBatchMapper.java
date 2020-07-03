package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.FieldType;
import com.chenbro.deliverybarcode.model.WoBatch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BoxMapper
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 10:34
 * @Version 1.0
 **/
public interface WoBatchMapper extends BaseMapper<WoBatch> {


    List<WoBatch> findAll(@Param("woNo") String woNo);


}
