package com.appagate.domain.exception;


/**
 * @author oscarriveros
 */
public class AppagateException extends RuntimeException {
    private ErrorCode code;

    public AppagateException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }
}