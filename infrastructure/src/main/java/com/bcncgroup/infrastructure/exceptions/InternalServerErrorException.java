package com.bcncgroup.infrastructure.exceptions;

import com.bcncgroup.domain.dto.ErrorDTO;

public class InternalServerErrorException extends RestException {

    private String codigoError;

    public InternalServerErrorException(String msg, String codigoError, Exception ex) {
        super(msg, ex);
        this.codigoError = codigoError;
    }

    public InternalServerErrorException(String msg, Exception ex) {
        super(msg, ex);
    }

    public InternalServerErrorException() {
        super();
    }

    public InternalServerErrorException(ErrorDTO errorDto) {
        super(errorDto);
    }

    public String getCodigoError() {
        return codigoError;
    }
}
