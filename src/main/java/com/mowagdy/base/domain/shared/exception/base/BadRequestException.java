package com.mowagdy.base.domain.shared.exception.base;

public class BadRequestException extends BaseException {
    public BadRequestException(String message) {
        super(ErrorStatusCode.BAD_REQUEST.getValue(), message);
    }
}
