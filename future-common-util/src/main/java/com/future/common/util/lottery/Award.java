package com.future.common.util.lottery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author future
 * @date 2021-05-26 10:57
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Award {

    /**
     * 奖品名字
     */
    private String name;

    /**
     * 奖品唯一标识-防止礼品名称重复
     */
    private String awardId;

    /**
     * 概率
     */
    private Integer rate;

}
