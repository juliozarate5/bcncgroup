package com.bcncgroup.infrastructure.exceptions;

import com.bcncgroup.domain.dto.ErrorDTO;

public class BadRequestException extends RestException {

    public BadRequestException() {
        super();
    }

    public BadRequestException(ErrorDTO errorDto) {
        super(errorDto);
    }

    public BadRequestException(String msg) {
        super(msg);
    }
}
