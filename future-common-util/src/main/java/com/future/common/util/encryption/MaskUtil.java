package com.future.common.util.encryption;

import org.apache.commons.lang3.StringUtils;

/**
 * @author future
 */
public class MaskUtil {

    /**
     * 功能描述: 脱敏手机号 182****2301
     *
     * @author future
     * @date 2021/6/28 10:08 上午
     */
    public static String maskMobile(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return StringUtils.EMPTY;
        }
        return StringUtils.overlay(phone, "****", 3, 7);
    }

    /**
     * 功能描述: 脱敏姓名
     *
     * @author future
     * @date 2021/6/28 10:13 上午
     */
    public static String maskName(String name) {
        if (StringUtils.isEmpty(name)) {
            return StringUtils.EMPTY;
        }
        return StringUtils.overlay(name, "*", 0, 1);
    }

    /**
     * 功能描述: 脱敏身份证 320***********5057
     *
     * @author future
     * @date 2021/6/28 10:08 上午
     */
    public static String maskIdCard(String idCard) {
        if (StringUtils.isEmpty(idCard)) {
            return StringUtils.EMPTY;
        }
        return StringUtils.overlay(idCard, "***********", 3, 14);
    }

}
