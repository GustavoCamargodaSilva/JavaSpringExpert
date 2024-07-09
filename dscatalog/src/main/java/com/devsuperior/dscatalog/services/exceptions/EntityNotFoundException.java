package com.devsuperior.dscatalog.services.exceptions;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String msg, HttpStatus status){
        super(msg);
    }
}
