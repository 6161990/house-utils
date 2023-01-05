package com.yoonji.houseUtils.exception;

public class HouseUtilsException extends RuntimeException{
    private ErrorCode errorCode;
    private String errorMessage;

    public HouseUtilsException(ErrorCode errorCode) {
        this(errorCode, errorCode.getErrorMessage());
    }

    public HouseUtilsException(ErrorCode errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
