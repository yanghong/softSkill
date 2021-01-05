package com.hunter.BizTest;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/4 23:04
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -6998389175825829723L;

    private T data;
    /**
     * 返回code
     */
    private String code;

    /**
     * 返回提示信息
     */
    private String msg;

    /**
     * 执行结果
     */
    private boolean success;

    public Result() {
    }

    /**
     * 执行成功
     *
     * @param data
     */
    public Result(T data) {
        this.code = "0001";
        this.msg = "操作成功";
        this.success = true;
        this.data = data;
    }

    /**
     * 执行，发生异常
     */
    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
        if (StringUtils.isBlank(msg)) {
            this.msg = "服务开了点小差";
        }
        this.success = false;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
