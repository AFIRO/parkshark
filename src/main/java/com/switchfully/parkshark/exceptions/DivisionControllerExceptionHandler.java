package com.switchfully.parkshark.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class DivisionControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(DivisionControllerExceptionHandler.class);

    @ExceptionHandler(NoSuchDivisionException.class)
    protected void noSuchDivisionException(NoSuchDivisionException exception, HttpServletResponse response) throws Exception {
        logger.error(exception.getMessage());
        response.sendError(HttpStatus.FORBIDDEN.value(), exception.getMessage());
    }

    @ExceptionHandler(BadCreateDivisionException.class)
    protected void badCreateDivisionException(BadCreateDivisionException exception, HttpServletResponse response) throws Exception {
        logger.error(exception.getMessage());
        response.sendError(HttpStatus.FORBIDDEN.value(), exception.getMessage());
    }
}
