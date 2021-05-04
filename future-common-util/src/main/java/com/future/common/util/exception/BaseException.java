package com.future.common.util.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务出错
 *
 * @author future
 * @date 2021/05/04 19:01
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseException extends RuntimeException {
    private Integer responseCode;
    private Object data;

    protected BaseException(Integer responseCode, String message, Object data, Throwable cause) {
        super(message, cause);
        this.setData(data);
        this.setResponseCode(responseCode);
    }

    public BaseException setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    public BaseException setData(Object data) {
        this.data = data;
        return this;
    }
}
