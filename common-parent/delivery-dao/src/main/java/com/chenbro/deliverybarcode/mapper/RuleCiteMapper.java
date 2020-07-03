package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.RuleCite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName CapacityMapper
 * @Description TODO
 * @Author c8777
 * @Date 2020/4/1 10:34
 * @Version 1.0
 **/
public interface RuleCiteMapper extends BaseMapper<RuleCite> {


    List<RuleCite> findAll(@Param("delMatno")String delMatno);


}
