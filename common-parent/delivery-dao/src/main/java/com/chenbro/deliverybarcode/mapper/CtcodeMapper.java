package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.Box;
import com.chenbro.deliverybarcode.model.Ctcode;
import com.chenbro.deliverybarcode.model.InspurPallet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BoxMapper
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 10:34
 * @Version 1.0
 **/
public interface CtcodeMapper extends BaseMapper<Ctcode> {


    List<Ctcode> findAll();

    List<Ctcode> findByConditions(Ctcode ctcode);

    Ctcode findByCtNumber(@Param("ctNumber") String ctNumber);

}
