package com.switchfully.parkshark.exceptions.parkinglot;

import com.switchfully.parkshark.exceptions.member.BadCreateAddressException;
import com.switchfully.parkshark.exceptions.member.BadCreateLicensePlateException;
import com.switchfully.parkshark.exceptions.member.BadCreateMemberException;
import com.switchfully.parkshark.exceptions.member.NoSuchMemberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ParkingLotControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(ParkingLotControllerExceptionHandler.class);

    @ExceptionHandler(NoSuchParkingLotException.class)
    protected void noSuchParkingLotException(NoSuchParkingLotException exception, HttpServletResponse response) throws Exception {
        logger.error(exception.getMessage());
        response.sendError(HttpStatus.FORBIDDEN.value(), exception.getMessage());
    }

}
