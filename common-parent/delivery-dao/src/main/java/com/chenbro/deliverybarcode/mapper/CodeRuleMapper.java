package com.chenbro.deliverybarcode.mapper;

import com.chenbro.deliverybarcode.mapper.base.BaseMapper;
import com.chenbro.deliverybarcode.model.CodeRule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BoxMapper
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 10:34
 * @Version 1.0
 **/
public interface CodeRuleMapper extends BaseMapper<CodeRule> {


    List<CodeRule> findAll();


    CodeRule findDetailByUuid(@Param("uuid") String uuid);

    CodeRule findDetailByRuleNo(@Param("ruleNo") String ruleNo);
}
