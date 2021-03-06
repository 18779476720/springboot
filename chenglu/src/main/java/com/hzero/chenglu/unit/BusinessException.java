package com.hzero.chenglu.unit;

public class BusinessException extends RuntimeException{
    private String code;
    private String msg;

    public BusinessException(XKHResponseCodeEnum xkhResponseCodeEnum) {
        super(xkhResponseCodeEnum.getChineseMessage());
        this.msg = xkhResponseCodeEnum.getMsg();
        this.code = xkhResponseCodeEnum.getCode();
    }

    public BusinessException() {
        super();
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
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
}
