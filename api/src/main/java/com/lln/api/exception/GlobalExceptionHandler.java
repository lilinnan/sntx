package com.lln.api.exception;

import com.lln.api.domain.Message;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/6/17 23:16
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Message handle(Exception exception) {
        exception.printStackTrace();
        return Message.builder().status(500).message(exception.getMessage()).build();
    }
}
