package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.Ctcode;
import com.chenbro.deliverybarcode.model.PrintModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BoxMapper
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 10:34
 * @Version 1.0
 **/
public interface PrintModelMapper extends BaseMapper<PrintModel> {


    List<PrintModel> findAll();


    PrintModel findByFileNo(@Param("fileNo") String fileNo);

}
