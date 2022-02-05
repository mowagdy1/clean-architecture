package com.mowagdy.base.domain.shared.validator;

import com.mowagdy.base.domain.shared.exception.base.BaseException;

public interface BaseValidator {
    void validateOrThrow() throws BaseException;
}
