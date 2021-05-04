package com.future.common.util.exception;

/**
 * 业务code
 *
 * @author future
 * @date 2021/05/04 19:04
 */
public interface ResponseCode {

    /**
     * 成功
     */
    Integer OK = 0;
    Integer SUCCESS = 200;

    /**
     * 失败
     */
    Integer FAIL=-1;
    Integer BAD_REQUEST = 400;
    Integer RESOURCE_NOT_FOUND = 404;
    Integer HTTP_METHOD_NOT_ALLOWED = 405;
    Integer HTTP_MEDIA_TYPE_UNSUPPORTED = 415;
    Integer SYSTEM_ERROR = 500;
    Integer VALIDATION_ERROR = 600;
    Integer AUTHENTICATION_FAIL = 601;
    Integer STATUS_ERROR = 602;
    Integer ENTITY_NOT_EXIST = 604;
    Integer ENTITY_ALREADY_EXIST = 605;
    Integer SERVICE_NOT_IMPLEMENT = 700;
    Integer SERVICE_INVOKE_ERROR = 701;
    Integer PARAMETER_MISSING = 800;
    Integer PARAMETER_TYPE = 801;
    Integer CONCURRENCY_FAIL = 1002;
    Integer OPERATION_FAIL = 900;
    Integer OPERATION_NOT_SUPPORT = 901;

}
