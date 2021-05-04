package com.future.common.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author future
 * @date 2021/05/04 23:36
 */
public class GsonUtil {

    private static final Gson GSON = new GsonBuilder().create();

    public static String beanToJson(Object obj) {
        return GSON.toJson(obj);
    }

    public static <T> T jsonToBean(String jsonStr, Class<T> objClass) {
        return GSON.fromJson(jsonStr, objClass);
    }

}
