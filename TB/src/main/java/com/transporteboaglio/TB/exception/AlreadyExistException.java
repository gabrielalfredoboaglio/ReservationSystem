package com.transporteboaglio.TB.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AlreadyExistException extends ResponseStatusException {
    public AlreadyExistException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}