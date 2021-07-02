package com.future.service.rule;

import com.future.service.rule.dto.AgeRuleData;
import com.future.service.rule.dto.BaseRuleContext;
import com.future.service.rule.dto.RuleData;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author future
 * @date 2021-07-02 17:51
 */
@Slf4j
public class RuleExecutor<T extends BaseRuleContext<R>, R extends RuleData> {

    private final Map<String, RuleInterface<T, R>> handlers = new HashMap<>();

    public void register(RuleInterface<T, R> handler) {
        if (handlers.containsKey(handler.getRuleCode())) {
            log.error(MessageFormat.format("rule executor register，code:{0}", handler.getRuleCode()));
            return;
        }
        handlers.put(handler.getRuleCode(), handler);
    }


    /**
     * 功能描述: 验证规则
     *
     * @author future
     * @date 2021/7/2 6:23 下午
     */
    @SuppressWarnings(value = "all")
    public boolean validate(Map<String, R> map) {
        for (Object obj : map.entrySet()) {
            Map.Entry<String, R> ruleEntry = (Map.Entry<String, R>) obj;
            boolean validate = this.handlers.get(ruleEntry.getKey()).validate(ruleEntry.getValue());
            if (!validate) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /**
     * 功能描述: 验证是否符合规则
     *
     * @author future
     * @date 2021/7/2 6:23 下午
     */
    @SuppressWarnings(value = "all")
    public boolean execute(T t) {
        for (Object obj : t.getRuleMap().entrySet()) {
            Map.Entry<String, R> ruleEntry = (Map.Entry<String, R>) obj;
            boolean validate = this.handlers.get(ruleEntry.getKey()).execute(t);
            if (!validate) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }


    public static void main(String[] args) {
        final RuleExecutor<BaseRuleContext<RuleData>, RuleData> executor = new RuleExecutor<>();
        executor.register((RuleInterface) new AgeRuleHandler());
        executor.register((RuleInterface) new DateRuleHandler());

        BaseRuleContext<RuleData> context = new BaseRuleContext<>();
        final AgeRuleData ageRuleData = new AgeRuleData();
        ageRuleData.setAge(10);

        Map<String, RuleData> map = new HashMap<>();
        map.put(EnumRule.AGE.getCode(), ageRuleData);
        final boolean validate = executor.validate(map);
        if (validate) {
            System.out.println("ok");
        }
    }
}
