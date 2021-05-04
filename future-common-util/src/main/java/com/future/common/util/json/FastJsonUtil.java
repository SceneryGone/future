package com.future.common.util.json;

import com.alibaba.fastjson.JSON;

/**
 * @author future
 * @date 2021/05/04 23:41
 */
public class FastJsonUtil {

    public static String beanToJson(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T jsonToBean(String jsonStr, Class<T> objClass) {
        return JSON.parseObject(jsonStr, objClass);
    }


}
