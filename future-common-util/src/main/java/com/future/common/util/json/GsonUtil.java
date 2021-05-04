package com.future.common.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 推荐使用:http://yaoguang.info/2020/06/15/java%E5%B8%B8%E7%94%A8JSON%E5%BA%93/
 * @see JacksonUtil
 *
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
