package com.bootcamp.pragma.transactionmicroservice.infrastructure.driving.http.exceptionhandler;

import com.bootcamp.pragma.transactionmicroservice.domain.exception.StockMicroserviceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class SupplyExceptionHandler {

    @ExceptionHandler(StockMicroserviceException.class)
    public ResponseEntity<ExceptionResponse> handleStockMicroserviceException(final StockMicroserviceException e) {
        ExceptionResponse response = new ExceptionResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.toString(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.badRequest().body(response);
    }

}
