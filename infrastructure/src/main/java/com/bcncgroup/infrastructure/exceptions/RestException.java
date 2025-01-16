package com.bcncgroup.infrastructure.exceptions;

import com.bcncgroup.domain.dto.ErrorDTO;

public class RestException extends Exception{

    private static final long serialVersionUID = 1L;
    private ErrorDTO errorDto;

    public RestException() {
        super();
    }

    public RestException(ErrorDTO errorDto) {
        super(errorDto.getError());
        this.errorDto = errorDto;
    }

    public RestException(String msg) {
        super(msg);
    }

    public RestException(String msg, Exception ex) {
        super(msg, ex);
    }

    /**
     * @return the errorDto
     */
    public ErrorDTO getErrorDto() {
        return errorDto;
    }

    /**
     * @param errorDto the errorDto to set
     */
    public void setErrorDto(ErrorDTO errorDto) {
        this.errorDto = errorDto;
    }
}
