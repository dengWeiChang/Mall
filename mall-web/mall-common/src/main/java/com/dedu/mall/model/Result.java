package com.dedu.mall.model;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Result<E> implements Serializable {
    private String code;
    private String msg;
    private E data;

    public Result() {
    }

    private Result(String code, String msg, E data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public static <E> Result<E> success() {
        return new Result("0", "success", (Object)null);
    }

    public static <E> Result<E> failed() {
        return new Result("-1", "failed", (Object)null);
    }

    public static <E> Result<E> build(String code) {
        return new Result(code, (String)null, (Object)null);
    }

    public static <E> Result<E> build(String code, E data) {
        return new Result(code, (String)null, data);
    }

    public static <E> Result<E> build(String code, String msg) {
        return new Result(code, msg, (Object)null);
    }

    public static <E> Result<E> build(String code, String msg, E data) {
        return new Result(code, msg, data);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
