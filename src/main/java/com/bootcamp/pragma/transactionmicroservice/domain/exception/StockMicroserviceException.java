package com.bootcamp.pragma.transactionmicroservice.domain.exception;

public class StockMicroserviceException extends RuntimeException {
    public StockMicroserviceException(final String message) {
        super(message);
    }
}
