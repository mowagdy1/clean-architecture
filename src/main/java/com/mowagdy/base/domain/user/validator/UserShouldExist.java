package com.mowagdy.base.domain.user.validator;

import com.mowagdy.base.domain.shared.exception.RequiredFieldException;
import com.mowagdy.base.domain.shared.validator.BaseValidator;
import com.mowagdy.base.domain.user.exception.UserNotFoundException;
import com.mowagdy.base.domain.user.port.UserRepoService;

public class UserShouldExist implements BaseValidator {

    private final Long id;
    private final UserRepoService userRepoService;

    public UserShouldExist(Long id, UserRepoService userRepoService) {
        this.id = id;
        this.userRepoService = userRepoService;
    }

    @Override
    public void validateOrThrow() throws RequiredFieldException {
        if (!userRepoService.isUserExists(id)) {
            throw new UserNotFoundException("User [" + id + "] not found.");
        }
    }
}
