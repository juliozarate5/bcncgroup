package com.bcncgroup.application.exceptions;

public class InternalServerErrorException extends RuntimeException {


    public InternalServerErrorException(String message) {
        super(message);
    }
}
