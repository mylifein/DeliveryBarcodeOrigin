package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.CodeRule;
import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.service.ICodeRuleService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName CodeRuleServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/27 15:31
 * @Version 1.0
 **/
@Controller
@Transactional
public class CodeRuleServiceImpl extends BaseServiceImpl<CodeRule> implements ICodeRuleService {


    @Override
    public List<CodeRule> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return codeRuleMapper.findAll();
    }

    @Override
    public CodeRule findDetailByUuid(String uuid) {
        return codeRuleMapper.findDetailByUuid(uuid);
    }

    @Override
    public CodeRule findByUUid(String uuid) {
        return null;
    }

    @Override
    public void deleteById(String uuid) throws CommonException {

    }

    @Override
    public void update(CodeRule codeRule) {

    }

    @Override
    public void insert(CodeRule codeRule) {

    }

    @Override
    public CodeRule findDetailByRuleNo(String ruleNo) {
        return codeRuleMapper.findDetailByRuleNo(ruleNo);
    }
}
