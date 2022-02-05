package com.mowagdy.base.domain.shared;

public abstract class BaseUseCase<Response> {

    protected abstract void validate();

    protected abstract Response process();

    public Response execute() {
        validate();
        return process();
    }
}
