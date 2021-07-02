package com.future.service.rule;

import com.future.service.rule.dto.DateRuleDate;
import com.future.service.rule.dto.DateRuleContext;

import java.util.Date;

/**
 * 功能描述:
 *
 * @author future
 * @date 2021-07-02 17:48
 */
public class DateRuleHandler implements RuleInterface<DateRuleContext, DateRuleDate> {

    @Override
    public String getRuleCode() {
        return EnumRule.DATE.getCode();
    }

    @Override
    public boolean validate(DateRuleDate ruleDate) {
        final Date now = new Date();
        return ruleDate.getBeginDate().before(now) && ruleDate.getEndDate().after(now);
    }

    @Override
    public boolean execute(DateRuleContext dateRuleContext) {
        return Boolean.TRUE;
    }

}
