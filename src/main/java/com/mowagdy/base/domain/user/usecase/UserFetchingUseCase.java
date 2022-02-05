package com.mowagdy.base.domain.user.usecase;

import com.mowagdy.base.domain.shared.BaseUseCase;
import com.mowagdy.base.domain.user.dto.UserFetchingResponse;
import com.mowagdy.base.domain.user.model.UserModel;
import com.mowagdy.base.domain.user.port.UserRepoService;
import com.mowagdy.base.domain.user.validator.UserShouldExist;

public class UserFetchingUseCase extends BaseUseCase<UserFetchingResponse> {

    private final Long id;
    private final UserRepoService userRepoService;

    public UserFetchingUseCase(Long id, UserRepoService userRepoService) {
        this.id = id;
        this.userRepoService = userRepoService;
    }

    @Override
    protected void validate() {
        new UserShouldExist(id, userRepoService).validateOrThrow();
    }

    @Override
    protected UserFetchingResponse process() {
        UserModel userModel = userRepoService.getSingleUser(id);
        return new UserFetchingResponse(userModel.getId(), userModel.getName());
    }
}
