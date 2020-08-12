package com.learn.demo.model;

/**
 * 状态码
 * 信息
 * 返回数据
 * @param <T>
 */
public class ResbBody<T> {
    private String statuscode;
    private String message;
    private T data;

    public ResbBody() {}


    public ResbBody(String statuscode, String message) {
        this.statuscode = statuscode;
        this.message = message;
    }

    public ResbBody(String statuscode, String message, T data) {
        this.statuscode = statuscode;
        this.message = message;
        this.data = data;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
