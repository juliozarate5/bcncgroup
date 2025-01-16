package com.bcncgroup.infrastructure.exceptions;

import com.bcncgroup.domain.dto.ErrorDTO;

public class NotFoundException extends RestException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(ErrorDTO errorDto) {
        super(errorDto);
    }
}
