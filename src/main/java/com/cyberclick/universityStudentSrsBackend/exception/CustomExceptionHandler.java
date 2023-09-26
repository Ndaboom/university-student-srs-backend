package com.cyberclick.universityStudentSrsBackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Responsible to handle exception with controller advice annotation
public class CustomExceptionHandler {
    @ExceptionHandler(value = {CustomNotFoundException.class}) // There can be many, separated with comma
    public ResponseEntity<Object>
    handlerCloudVendorNotFoundException(CustomNotFoundException cloudVendorNotFoundException){
        CustomException cloudVendorException = new CustomException(
                cloudVendorNotFoundException.getMessage(),
                cloudVendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }
}
