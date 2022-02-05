package com.mowagdy.base.domain.shared.validator;

import com.mowagdy.base.domain.shared.exception.RequiredFieldException;

public class FieldShouldBePresent<T> implements BaseValidator {

    private final T value;
    private final String key;

    public FieldShouldBePresent(T value, String key) {
        this.value = value;
        this.key = key;
    }

    @Override
    public void validateOrThrow() throws RequiredFieldException {

        boolean result = false;

        if (value instanceof String) {
            result = !value.equals("");
        } else if (value instanceof Long) {
            result = !value.equals(0L);
        } else if (value instanceof Integer) {
            result = !value.equals(0);
        } else if (value instanceof Double) {
            result = !value.equals(0.0);
        } else if (value instanceof Enum) {
            result = !value.toString().toLowerCase().equals("none");
        }

        if (!result) {
            throw new RequiredFieldException("Field [" + key + "] is required");
        }
    }
}
