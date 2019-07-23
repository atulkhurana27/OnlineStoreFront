package com.OnlineStore.models;

import java.util.Objects;

public class Rule {
    private String ruleName;
    private RuleConstants ruleKey;
    private RuleConstants ruleScope;
    private RuleConstants ruleType;
    private RuleConstants ruleOperation;
    private Double comparisonValue; // acts as count comparisonvalue
    private Double dealValue; // acts as discount percentage in case  of ruleType as quantity and amount in case of cost

    public Rule() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rule)) return false;
        Rule rule = (Rule) o;
        return Objects.equals(ruleName, rule.ruleName) &&
                ruleKey.equals(rule.ruleKey) &&
                ruleScope.equals(rule.ruleScope) &&
                ruleType.equals(rule.ruleType) &&
                ruleOperation.equals(rule.ruleOperation) &&
                Objects.equals(comparisonValue, rule.comparisonValue) &&
                Objects.equals(dealValue, rule.dealValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruleName, ruleKey, ruleScope, ruleType, ruleOperation, comparisonValue, dealValue);
    }

    public Rule(String ruleName, RuleConstants ruleKey, RuleConstants ruleScope, RuleConstants ruleType, RuleConstants ruleOperation, Double comparisonValue, Double dealValue) {
        this.ruleName = ruleName;
        this.ruleKey = ruleKey;
        this.ruleScope = ruleScope;
        this.ruleType = ruleType;
        this.ruleOperation = ruleOperation;
        this.comparisonValue = comparisonValue;
        this.dealValue = dealValue;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public RuleConstants getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(RuleConstants ruleKey) {
        this.ruleKey = ruleKey;
    }

    public RuleConstants getRuleScope() {
        return ruleScope;
    }

    public void setRuleScope(RuleConstants ruleScope) {
        this.ruleScope = ruleScope;
    }

    public RuleConstants getRuleType() {
        return ruleType;
    }

    public void setRuleType(RuleConstants ruleType) {
        this.ruleType = ruleType;
    }

    public RuleConstants getRuleOperation() {
        return ruleOperation;
    }

    public void setRuleOperation(RuleConstants ruleOperation) {
        this.ruleOperation = ruleOperation;
    }

    public Double getComparisonValue() {
        return comparisonValue;
    }

    public void setComparisonValue(Double comparisonValue) {
        this.comparisonValue = comparisonValue;
    }

    public Double getDealValue() {
        return dealValue;
    }

    public void setDealValue(Double dealValue) {
        this.dealValue = dealValue;
    }
}
