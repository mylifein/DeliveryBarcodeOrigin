package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.MandFieldCite;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @ClassName ModelCiteMapper
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 10:34
 * @Version 1.0
 **/
public interface MandFieldCiteMapper extends BaseMapper<MandFieldCite> {


    List<MandFieldCite> findAll(@Param("delMatno") String delMatno);



}
