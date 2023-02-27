package com.summary.hml.viper.common.exception;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-02-21 16:04
 * @Description : 自定义异常
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = -9012378910035579760L;

    /**
     * 异常描述
     */
    private String message = "未知异常";

    /**
     * 错误码
     */
    private ErrorCode errorCode = ErrorCode.UNKNOWN_SYSTEM_EXCEPTION;

    /**
     * 不打印堆栈信息
     */
    @Override
    public Throwable fillInStackTrace(){
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public BaseException(String message, ErrorCode errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public BaseException(String message, String message1, ErrorCode errorCode) {
        super(message);
        this.message = message1;
        this.errorCode = errorCode;
    }

    public BaseException(String message, Throwable cause, String message1, ErrorCode errorCode) {
        super(message, cause);
        this.message = message1;
        this.errorCode = errorCode;
    }

    public BaseException(Throwable cause, String message, ErrorCode errorCode) {
        super(cause);
        this.message = message;
        this.errorCode = errorCode;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1, ErrorCode errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
        this.errorCode = errorCode;
    }
}
