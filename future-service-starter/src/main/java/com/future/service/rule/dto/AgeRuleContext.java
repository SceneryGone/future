package com.future.service.rule.dto;

import lombok.Data;

/**
 * 功能描述:
 *
 * @author future
 * @date 2021-07-02 18:54
 */
@Data
public class AgeRuleContext extends BaseRuleContext<AgeRuleData>{

    private String userAge;

}
