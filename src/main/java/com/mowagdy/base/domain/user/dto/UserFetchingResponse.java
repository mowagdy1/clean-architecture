package com.mowagdy.base.domain.user.dto;

public class UserFetchingResponse {
    private Long id;
    private String name;

    public UserFetchingResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
