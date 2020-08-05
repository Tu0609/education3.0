package com.education.util.tools;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TuTu
 * @date 2020/6/23 14:02
 */
@Data
public class ResultUtils {

    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<String, Object>();

    //把构造方法私有
    private ResultUtils() {}

    //成功静态方法
    public static ResultUtils ok() {
        ResultUtils resultUtils = new ResultUtils();
        resultUtils.setSuccess(true);
        resultUtils.setCode(200);
        resultUtils.setMessage("成功");
        return resultUtils;
    }

    public static ResultUtils ok(Map<String, Object> map) {
        ResultUtils resultUtils = new ResultUtils();
        resultUtils.setSuccess(true);
        resultUtils.setCode(200);
        resultUtils.setMessage("成功");
        resultUtils.setData(map);
        return resultUtils;
    }

    //失败静态方法
    public static ResultUtils error() {
        ResultUtils resultUtils = new ResultUtils();
        resultUtils.setSuccess(false);
        resultUtils.setCode(500);
        resultUtils.setMessage("失败");
        return resultUtils;
    }

    public ResultUtils success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public ResultUtils message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultUtils code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultUtils data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ResultUtils data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
