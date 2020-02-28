package com.hzero.chenglu.unit;

public enum XKHResponseCodeEnum {
    /**
     * 基础异常00
     */
    SUCCESS("000001", "SUCCESS", "成功"),
    SYSTEM_ERROR("000002", "SYSTEM_ERROR", "系统异常"),
    PARAM_INVALID("000003", "PARAM_INVALID", "请求参数无效"),
    NOUSER("000004", "NOUSER", "该用户不存在"),
    PASS_ERROR("000005", "PASS_ERROR", "密码错误"),
    PARAM_IS_NULL("000006", "PARAM_IS_NULL", "参数不能为空");

    private String code;
    private String msg;
    private String chineseMessage;


    XKHResponseCodeEnum(String code, String msg, String chineseMessage) {
        this.code = code;
        this.msg = msg;
        this.chineseMessage = chineseMessage;
    }


    public String getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    /**
     * 获取中文错误信息
     *
     * @return
     */
    public String getChineseMessage() {
        return chineseMessage;
    }

    @Override
    public String toString() {
        return "XKHResponseCodeEnum{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", chineseMessage='" + chineseMessage + '\'' +
                '}';
    }
}
