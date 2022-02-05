package com.mowagdy.base.domain.shared.dto;

import java.util.Date;
import java.util.Map;

public class ErrorDto {
    private final Date timestamp;
    private final String exception;
    private final String message;
    private final Map<String, Object> params;

    public ErrorDto(String exception, String message, Map<String, Object> params) {
        this.timestamp = new Date();
        this.exception = exception;
        this.message = message;
        this.params = params;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getParams() {
        return params;
    }
}
