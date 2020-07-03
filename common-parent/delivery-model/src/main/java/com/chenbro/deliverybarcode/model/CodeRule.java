package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

import java.util.List;

/**
 * @ClassName CodeRule
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/27 14:07
 * @Version 1.0
 **/
public class CodeRule extends BaseEntity {

    private String ruleNo;
    private String ruleDesc;
    private List<RuleContent> ruleContents;

    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public List<RuleContent> getRuleContents() {
        return ruleContents;
    }

    public void setRuleContents(List<RuleContent> ruleContents) {
        this.ruleContents = ruleContents;
    }
}
