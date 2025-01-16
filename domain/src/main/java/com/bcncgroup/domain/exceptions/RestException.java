package com.bcncgroup.domain.exceptions;

import com.bcncgroup.domain.dto.ErrorDTO;

public class RestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    // Cambiado a final para inmutabilidad
    private final ErrorDTO errorDto;

    // Constructor sin argumentos, útil para casos excepcionales donde no hay detalles
    public RestException() {
        super();
        this.errorDto = null;
    }

    // Constructor que acepta un ErrorDTO
    public RestException(ErrorDTO errorDto) {
        super(errorDto != null ? errorDto.getError() : null);
        this.errorDto = errorDto;
    }

    // Constructor con mensaje personalizado
    public RestException(String msg) {
        super(msg);
        this.errorDto = null;
    }

    // Constructor con mensaje y causa
    public RestException(String msg, Exception ex) {
        super(msg, ex);
        this.errorDto = null;
    }

    /**
     * @return the errorDto
     */
    public ErrorDTO getErrorDto() {
        return errorDto;
    }

    @Override
    public String toString() {
        return "RestException{" +
                "errorDto=" + errorDto +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}
