package com.mowagdy.base.infrastructure.shared.exception;

import com.mowagdy.base.domain.shared.dto.ErrorDto;
import com.mowagdy.base.domain.shared.exception.base.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> processLogicalException(BaseException ex) {
        return new ResponseEntity<>(ex.toErrorDto(), HttpStatus.valueOf(ex.getStatus()));
    }
}
