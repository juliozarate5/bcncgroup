package com.bcncgroup.domain.exceptions;

import com.bcncgroup.domain.dto.ErrorDTO;

public class InternalServerErrorException extends RestException {

    private final String codigoError;

    // Constructor principal con mensaje, código de error y causa
    public InternalServerErrorException(String msg, String codigoError, Exception ex) {
        super(msg, ex);
        this.codigoError = codigoError;
    }

    // Constructor con mensaje y causa
    public InternalServerErrorException(String msg, Exception ex) {
        super(msg, ex);
        this.codigoError = null; // Por defecto, null si no se proporciona
    }

    // Constructor con ErrorDTO
    public InternalServerErrorException(ErrorDTO errorDto) {
        super(errorDto);
        this.codigoError = null; // Depende de cómo manejes ErrorDTO
    }

    public String getCodigoError() {
        return codigoError;
    }

    @Override
    public String toString() {
        return "InternalServerErrorException{" +
                "codigoError='" + codigoError + '\'' +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}
