package com.taskplanner.users.exception;

import com.taskplanner.users.dto.server.ServerErrorResponseDto;
import com.taskplanner.users.utils.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

import javax.ws.rs.InternalServerErrorException;

/**
 * @author Laura Garcia
 */
public class InvalidCredentialsException extends InternalServerErrorException {

    public InvalidCredentialsException() {
        super();
        ServerErrorResponseDto serverErrorResponseDto = new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
    }

}
