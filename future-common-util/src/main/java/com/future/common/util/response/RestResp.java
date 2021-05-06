package com.future.common.util.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author holmes
 */
@Data
public class RestResp<T> implements Serializable {

    private static final Integer SUCCESS_CODE = 0;

    private static final Integer ERROR_CODE = -1;

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public static <T> RestResp<T> getFailure(Integer code, String message) {
        return new RestResp<>(code == null ? -1 : code, message, null);
    }

    public static <T> RestResp<T> ok() {
        return ok(null);
    }

    public static <T> RestResp<T> ok(T result) {
        return new RestResp<>(SUCCESS_CODE, "请求成功", result);
    }

    public static <T> RestResp<T> fail(Integer code, String message) {
        return new RestResp<>(code, message, null);
    }

    public static <T> RestResp<T> getFailureException() {
        return getFailure(null, "处理失败，返回系统异常");
    }

    public RestResp(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public RestResp() {

    }

}
