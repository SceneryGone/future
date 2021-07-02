package com.future.service.rule;

import com.future.service.rule.dto.BaseRuleContext;
import com.future.service.rule.dto.RuleData;

/**
 * @author future
 */
public interface RuleInterface<T extends BaseRuleContext<R>, R extends RuleData> {

    String getRuleCode();

    /**
     * 功能描述: 验证规则
     *
     * @author future
     * @date 2021/7/2 6:25 下午
     */
    boolean validate(R ruleDate);

    /**
     * 功能描述: 验证是否符合规则
     *
     * @author future
     * @date 2021/7/2 5:45 下午
     */
    boolean execute(T ruleContext);
}
