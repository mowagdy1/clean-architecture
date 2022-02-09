package com.mowagdy.base.domain.user.usecase;

import com.mowagdy.base.domain.shared.BaseUseCase;
import com.mowagdy.base.domain.user.dto.UserFetchingResponse;
import com.mowagdy.base.domain.user.model.User;
import com.mowagdy.base.domain.user.repo.UserRepo;
import com.mowagdy.base.domain.user.validator.UserShouldExist;

public class UserFetchingUseCase extends BaseUseCase<UserFetchingResponse> {

    private final Long id;
    private final UserRepo userRepo;

    public UserFetchingUseCase(Long id, UserRepo userRepo) {
        this.id = id;
        this.userRepo = userRepo;
    }

    @Override
    protected void validate() {
        new UserShouldExist(id, userRepo).validateOrThrow();
    }

    @Override
    protected UserFetchingResponse process() {
        User user = userRepo.getSingleUser(id);
        return new UserFetchingResponse(user.getId(), user.getName());
    }
}
