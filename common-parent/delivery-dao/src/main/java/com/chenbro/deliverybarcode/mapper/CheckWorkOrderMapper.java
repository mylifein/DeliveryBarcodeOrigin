package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.CheckQueryCond;
import com.chenbro.deliverybarcode.model.CheckWorkOrder;
import com.chenbro.deliverybarcode.model.response.CheckReportResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BoxMapper
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 10:34
 * @Version 1.0
 **/
public interface CheckWorkOrderMapper extends BaseMapper<CheckWorkOrder> {


    List<CheckWorkOrder> findCheckWorkOrderByStatus(String status);

    CheckWorkOrder findById(String id);


    CheckWorkOrder findDetailById(@Param("uuid") String uuid);

    List<CheckReportResult> queryReportByCond(CheckQueryCond checkQueryCond);

    List<CheckWorkOrder> findAll(@Param("woNo")String woNo);

}
