package com.example.backendb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OrderNotFoundException extends ResponseStatusException {
    public OrderNotFoundException(String s) {
        super(HttpStatus.NOT_FOUND, s);
    }
}
