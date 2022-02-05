package com.mowagdy.base.domain.shared.dto;

public class ResponseWithId {

    private final Long id;

    public ResponseWithId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
