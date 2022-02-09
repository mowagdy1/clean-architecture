package com.mowagdy.base.domain.user.validator;

import com.mowagdy.base.domain.shared.exception.RequiredFieldException;
import com.mowagdy.base.domain.shared.validator.BaseValidator;
import com.mowagdy.base.domain.user.exception.UserNotFoundException;
import com.mowagdy.base.domain.user.repo.UserRepo;

public class UserShouldExist implements BaseValidator {

    private final Long id;
    private final UserRepo userRepo;

    public UserShouldExist(Long id, UserRepo userRepo) {
        this.id = id;
        this.userRepo = userRepo;
    }

    @Override
    public void validateOrThrow() throws RequiredFieldException {
        if (!userRepo.isUserExists(id)) {
            throw new UserNotFoundException("User [" + id + "] not found.", id);
        }
    }
}
