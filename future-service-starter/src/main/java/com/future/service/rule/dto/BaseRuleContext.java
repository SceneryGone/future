package com.future.service.rule.dto;

import lombok.Data;

import java.util.Map;

/**
 * 功能描述:
 *
 * @author future
 * @date 2021-07-02 18:14
 */
@Data
public class BaseRuleContext<R extends RuleData> {

    private Map<String, R> ruleMap;

}
