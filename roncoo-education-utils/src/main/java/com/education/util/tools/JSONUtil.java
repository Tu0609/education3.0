package com.education.util.tools;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TuTu
 * @date 2020/6/22 17:20
 */
public class JSONUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJSONString(Object o) {
        try {
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return "";
        }
    }


    /**
     *  将字符串转换为list集合
     * @param jsonString
     * @param elementClasses
     * @param <T>
     * @return
     */
    public static <T> List<T> parseArray(String jsonString, Class<T> elementClasses) {
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, elementClasses);
        try {
            return objectMapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            return null;
        }
    }


}
