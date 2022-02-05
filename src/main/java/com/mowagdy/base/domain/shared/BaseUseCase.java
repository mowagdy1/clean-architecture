package com.mowagdy.base.domain.shared;

import com.mowagdy.base.domain.shared.exception.base.BaseException;

public abstract class BaseUseCase<Response> {

    protected abstract void validate();

    protected abstract Response process();

    public Response execute() throws BaseException {
        validate();
        return process();
    }
}
