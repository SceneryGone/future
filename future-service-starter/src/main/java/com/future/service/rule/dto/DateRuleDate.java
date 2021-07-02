package com.future.service.rule.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 功能描述:
 *
 * @author future
 * @date 2021-07-02 17:42
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DateRuleDate extends RuleData {

    private Date beginDate;

    private Date endDate;

}
