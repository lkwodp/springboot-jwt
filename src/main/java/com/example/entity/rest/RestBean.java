package com.example.entity.rest;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import netscape.javascript.JSObject;

/**
 * @author blbyd_li
 * @data 2023/9/8
 * @apiNote
 */
public record RestBean<T>(int code,T data,String message) {
    public static <T> RestBean<T> success(T data){
        return new RestBean<>(200,data,"请求成功");
    }
    public static <T> RestBean<T> success(){
        return success(null);
    }
    public static <T> RestBean<T> failure(int code,String message){
        return new RestBean<>(code,null,message);
    }

    public static <T> RestBean<T> unauthorized(String message){
        return new RestBean<>(401,null,message);
    }

    public static <T> RestBean<T> forbidden(String message){
        return new RestBean<>(403,null,message);
    }


    public String asJsonString(){
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }
}
