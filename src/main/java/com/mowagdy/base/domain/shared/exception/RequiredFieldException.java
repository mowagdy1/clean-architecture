package com.mowagdy.base.domain.shared.exception;

import com.mowagdy.base.domain.shared.exception.base.BadRequestException;

public class RequiredFieldException extends BadRequestException {
    public RequiredFieldException(String message, String requiredField) {
        super(message);
        addParam("requiredField", requiredField);
    }
}
