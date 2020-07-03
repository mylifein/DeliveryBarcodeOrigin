package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.ModelCite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ModelCiteMapper
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 10:34
 * @Version 1.0
 **/
public interface ModelCiteMapper extends BaseMapper<ModelCite> {


    List<ModelCite> findAll(@Param("delMatno")String delMatno);


    ModelCite findDetailByUuid(@Param("uuid") String uuid);
}
