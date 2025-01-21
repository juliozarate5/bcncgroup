package com.bcncgroup.infrastructure.config;

import com.bcncgroup.domain.dto.ErrorDTO;
import com.bcncgroup.domain.exceptions.BadRequestException;
import com.bcncgroup.domain.exceptions.InternalServerErrorException;
import com.bcncgroup.domain.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.bcncgroup.infrastructure.rest")
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDTO> getGeneralException(Exception e) {
        log.error(e.getMessage(), e);
        ErrorDTO errorRq = ErrorDTO.getErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorRq, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({InternalServerErrorException.class})
    public ResponseEntity<ErrorDTO> getGeneralException(InternalServerErrorException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(e.getErrorDto(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorDTO> getNotFoundRquest(NotFoundException e) {
        log.info(e.getMessage());
        return new ResponseEntity<>(e.getErrorDto(), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorDTO> getBadRequestException(BadRequestException e) {
        log.info(e.getErrorDto().getMessage());
        return new ResponseEntity<>(e.getErrorDto(), HttpStatus.BAD_REQUEST);
    }
}
