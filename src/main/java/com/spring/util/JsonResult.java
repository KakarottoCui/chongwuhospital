package com.spring.util;

/**
 * Json 数据返回格式
 */
public class JsonResult {
    private Integer code;
    private String msg;
    private Object data;

    public JsonResult(Integer code , String msg , Object data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Object data)
    {
        this.data = data;
        setCode(0);
        setMsg("");
    }

    public JsonResult(String msg)
    {
        this.msg = msg;
        setData(null);
        setCode(1);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
