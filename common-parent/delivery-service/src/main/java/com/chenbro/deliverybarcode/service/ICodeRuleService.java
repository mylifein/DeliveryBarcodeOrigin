package com.chenbro.deliverybarcode.service;

import com.chenbro.deliverybarcode.model.CodeRule;
import com.chenbro.deliverybarcode.service.base.IBaseService;

import java.util.List;

public interface ICodeRuleService extends IBaseService<CodeRule> {

    List<CodeRule> findAll(int pageNum, int pageSize);

    CodeRule findDetailByUuid(String uuid);


    CodeRule findDetailByRuleNo(String ruleNo);
}
