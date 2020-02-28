package com.hzero.chenglu.unit;

import java.io.Serializable;
import java.util.List;


public class ReturnT<T> implements Serializable {

    public static ReturnT<String> buildSuccess = new ReturnT("00000","success","");
    /**
     * 返回code
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T datas;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public static <T> ReturnT<T> build(String code, String msg) {
        ReturnT<T> apiResult = new ReturnT<T>();
        apiResult.setCode(code);
        apiResult.setMessage(msg);
        return apiResult;
    }

    public static <T> ReturnT<T> build(String code, String msg, T datas) {
        ReturnT<T> apiResult = new ReturnT<T>();
        apiResult.setCode(code);
        apiResult.setMessage(msg);
        apiResult.setDatas(datas);
        return apiResult;
    }

    public static <T> ReturnT<T> build(XKHResponseCodeEnum xkhResponseCodeEnum) {
        ReturnT<T> apiResult = new ReturnT<T>();
        apiResult.setCode(xkhResponseCodeEnum.getCode());
        apiResult.setMessage(xkhResponseCodeEnum.getChineseMessage());
        return apiResult;
    }

    public static <T> ReturnT<T> buildSuccess(T datas) {
        ReturnT<T> apiResult = new ReturnT<T>();
        apiResult.setCode(XKHResponseCodeEnum.SUCCESS.getCode());
        apiResult.setMessage(XKHResponseCodeEnum.SUCCESS.getChineseMessage());
        apiResult.setDatas(datas);
        return apiResult;
    }
    public static <T> ReturnT<T> buildSuccess() {
        ReturnT<T> apiResult = new ReturnT<T>();
        apiResult.setCode(XKHResponseCodeEnum.SUCCESS.getCode());
        apiResult.setMessage(XKHResponseCodeEnum.SUCCESS.getChineseMessage());
        return apiResult;
    }

    public ReturnT(String code, String message, T datas) {
        this.code = code;
        this.message = message;
        this.datas = datas;
    }

    public static <T> T successDatas(ReturnT<T> apiResult) {
        if (apiResult == null) {
            throw new BusinessException(XKHResponseCodeEnum.PARAM_IS_NULL);
        }
        if (XKHResponseCodeEnum.SUCCESS.getCode().equals(apiResult.getCode())) {
            return apiResult.getDatas();
        }
        throw new BusinessException(apiResult.getCode(), apiResult.getMessage());
    }
    public ReturnT() {
    }

    @Override
    public String toString() {
        return "ReturnT{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", datas=" + datas +
                '}';
    }

}
