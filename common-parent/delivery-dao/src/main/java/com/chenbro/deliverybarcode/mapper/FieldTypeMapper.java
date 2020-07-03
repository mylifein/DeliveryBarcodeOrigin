package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.FieldType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BoxMapper
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 10:34
 * @Version 1.0
 **/
public interface FieldTypeMapper extends BaseMapper<FieldType> {


    List<FieldType> findAll();


    FieldType findDetailByUUId(@Param("uuid") String uuid);

}
