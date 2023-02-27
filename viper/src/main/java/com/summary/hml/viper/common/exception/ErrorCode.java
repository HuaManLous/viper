package com.summary.hml.viper.common.exception;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-02-27 10:47
 * @Description : 错误码
 */
public enum ErrorCode {


    UNKNOWN_SYSTEM_EXCEPTION("001", "ERROR", "系统异常"),

    UNKNOWN_VOCATIONAL_EXCEPTION("002", "EXCEPTION", "未知业务异常");

    /**
     * 错误编码
     */
    private String code;

    /**
     * 错误编码名称
     */
    private String codeName;

    /**
     * 错误描述
     */
    private String desc;

    /**
     * 日志等级
     */
    private String codeLevel;

    /**
     * 日志类型
     */
    private String codeType;

    /**
     * 系统错误码
     */
    private String systemErrorCode;

    /**
     *  基础架构保持一致
     */
    // private ResultCode resultCode;

    /**
     * 事件码
     */
    // private EventCode eventCode;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    ErrorCode(String code, String codeName, String desc) {
        this.code = code;
        this.codeName = codeName;
        this.desc = desc;
    }
}
