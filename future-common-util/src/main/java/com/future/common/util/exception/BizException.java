package com.future.common.util.exception;

/**
 * 业务出错
 *
 * @author future
 * @date 2021/05/04 19:01
 */
public class BizException extends BaseException {

    protected BizException(Integer responseCode) {
        this(responseCode, "");
    }

    protected BizException(Integer responseCode, String message) {
        this(responseCode, message, null);
    }

    protected BizException(Integer responseCode, String message, Object object) {
        super(responseCode, message, object, null);
    }

    protected BizException(String message) {
        this(ResponseCode.FAIL, message, null);
    }

    public static BizException of(Integer code, String message) {
        return new BizException(code, message);
    }

}
