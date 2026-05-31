package com.workintech.s18d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BurgerErrorException.class)
    public ResponseEntity<BurgerErrorResponse> handleBurgerException(BurgerErrorException ex) {

        log.error("BurgerErrorException occurred: {}", ex.getMessage());

        BurgerErrorResponse response =
                new BurgerErrorResponse(ex.getMessage());

        return new ResponseEntity<>(response, ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BurgerErrorResponse> handleGeneralException(Exception ex) {

        log.error("Unexpected error: {}", ex.getMessage());

        return new ResponseEntity<>(
                new BurgerErrorResponse("Unexpected error occurred"),
                HttpStatus.BAD_REQUEST
        );
    }
}
