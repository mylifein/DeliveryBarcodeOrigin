package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.BaseEntity;

/**
 * @ClassName RuleContent
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/27 14:13
 * @Version 1.0
 **/
public class RuleContent extends BaseEntity {

    private String ruleNo;
    private String sequence;
    private String typeNo;
    private String ruleValue;
    private Integer ruleLength;
    private RuleType ruleType;

    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }

    public String getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }

    public Integer getRuleLength() {
        return ruleLength;
    }

    public void setRuleLength(Integer ruleLength) {
        this.ruleLength = ruleLength;
    }

    public RuleType getRuleType() {
        return ruleType;
    }

    public void setRuleType(RuleType ruleType) {
        this.ruleType = ruleType;
    }
}
