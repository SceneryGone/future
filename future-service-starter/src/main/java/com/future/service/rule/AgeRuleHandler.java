package com.future.service.rule;

import com.future.service.rule.dto.AgeRuleContext;
import com.future.service.rule.dto.AgeRuleData;

import java.util.Map;

/**
 * 功能描述:
 *
 * @author future
 * @date 2021-07-02 17:46
 */
public class AgeRuleHandler implements RuleInterface<AgeRuleContext, AgeRuleData> {

    @Override
    public String getRuleCode() {
        return EnumRule.AGE.getCode();
    }

    @Override
    public boolean validate(AgeRuleData ruleDate) {
        return ruleDate.getAge() > 10;
    }

    @Override
    public boolean execute(AgeRuleContext context) {
        String userAge = context.getUserAge();
        for (Map.Entry<String, AgeRuleData> entry : context.getRuleMap().entrySet()) {

        }
        return Boolean.TRUE;
    }

}
