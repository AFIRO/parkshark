package com.switchfully.parkshark.exceptions.allocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class AllocationControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(AllocationControllerExceptionHandler.class);

    @ExceptionHandler(AllocationAlreadyStoppedException.class)
    protected void AllocationAlreadyExistsException(AllocationAlreadyStoppedException exception, HttpServletResponse response) throws Exception {
        logger.error(exception.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(NoSuchAllocationException.class)
    protected void NoSuchAllocationException(NoSuchAllocationException exception, HttpServletResponse response) throws Exception {
        logger.error(exception.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(WrongOwnerOfAllocationException.class)
    protected void WrongOwnerOfAllocationException(WrongOwnerOfAllocationException exception, HttpServletResponse response) throws Exception {
        logger.error(exception.getMessage());
        response.sendError(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
    }

    @ExceptionHandler(WrongOwnerOfLicensePlateException.class)
    protected void WrongOwnerOfLicensePlateException(WrongOwnerOfLicensePlateException exception, HttpServletResponse response) throws Exception {
        logger.error(exception.getMessage());
        response.sendError(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
    }

}
