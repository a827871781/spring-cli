package com.syz.cli.exception;

/**
 * 系统逻辑异常
 */
public class LogicException extends RuntimeException{

    private String errorCode;

    private String errorInfo;

    private LogicException(){}

    public LogicException(String message){super(message);}

    public LogicException(Throwable cause){super(cause);};

    public LogicException(String errorCode, String errorInfo){

        super("errorCode:"+errorCode+",errorInfo:"+errorInfo);

        this.errorCode=errorCode;
        this.errorInfo=errorInfo;

    }
    public LogicException(String errorCode, String errorInfo, Throwable cause){

        super("errorCode:"+errorCode+",errorInfo:"+errorInfo,cause);
        this.errorCode=errorCode;
        this.errorInfo=errorInfo;

    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }
}
