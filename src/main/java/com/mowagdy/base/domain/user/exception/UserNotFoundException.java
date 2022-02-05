package com.mowagdy.base.domain.user.exception;

import com.mowagdy.base.domain.shared.exception.base.BadRequestException;

public class UserNotFoundException extends BadRequestException {
    public UserNotFoundException(String message, Long id) {
        super(message);
        addParam("userId", id);
    }
}
