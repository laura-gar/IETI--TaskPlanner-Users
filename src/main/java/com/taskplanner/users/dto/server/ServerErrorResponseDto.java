package com.taskplanner.users.dto.server;

import com.taskplanner.users.utils.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

/**
 * @author Laura Garcia
 */
public class ServerErrorResponseDto {
    String  message;
    ErrorCodeEnum errorCode;
    int  httpStatus;

    public  ServerErrorResponseDto(String  message, ErrorCodeEnum  errorCode, HttpStatus httpStatus) {
        this.message = message;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus.value();
    }
    public  String  getMessage() {
        return  message;
    }

    public  ErrorCodeEnum  getErrorCode() {
        return  errorCode;
    }

    public  int  getHttpStatus() {
        return  httpStatus;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrorCode(ErrorCodeEnum errorCode) {
        this.errorCode = errorCode;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
}
