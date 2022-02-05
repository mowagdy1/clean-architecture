package com.mowagdy.base.domain.shared.exception.base;

public enum ErrorStatusCode {
    BAD_REQUEST(400),
    FORBIDDEN(403),
    ;

    private final int value;

    ErrorStatusCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
