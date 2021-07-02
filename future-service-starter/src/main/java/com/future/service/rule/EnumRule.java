package com.future.service.rule;

/**
 * 功能描述:
 *
 * @author future
 * @date 2021-07-02 17:59
 */
public enum EnumRule {
    DATE("10001"),
    AGE("1002");

    private String code;

    private EnumRule(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
