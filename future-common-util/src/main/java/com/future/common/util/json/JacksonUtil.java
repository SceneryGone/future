package com.future.common.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author future
 * @date 2021/05/04 23:41
 */
public class JacksonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String beanToJson(Object obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static <T> T jsonToBean(String jsonStr, Class<T> objClass) {
        try {
            return MAPPER.readValue(jsonStr, objClass);
        } catch (IOException e) {
            return null;
        }
    }


}
