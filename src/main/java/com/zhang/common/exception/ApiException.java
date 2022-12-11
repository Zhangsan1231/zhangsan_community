package com.zhang.common.exception;


import com.zhang.common.api.IErrorCode;

public class ApiException extends RuntimeException {
    private IErrorCode errorCode;
//  调用父类抛出自定义异常状态码
    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
//  抛出异常信息
    public ApiException(String message) {
        super(message);
    }
//  获得异常状态码
    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
