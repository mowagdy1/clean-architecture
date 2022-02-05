package com.mowagdy.base.domain.user.usecase;

import com.mowagdy.base.domain.shared.BaseUseCase;
import com.mowagdy.base.domain.shared.dto.ResponseWithId;
import com.mowagdy.base.domain.shared.validator.FieldShouldBePresent;
import com.mowagdy.base.domain.user.dto.UserCreatingRequest;
import com.mowagdy.base.domain.user.model.UserModel;
import com.mowagdy.base.domain.user.port.UserRepoService;

public class UserCreatingUseCase extends BaseUseCase<ResponseWithId> {

    private final UserCreatingRequest request;
    private final UserRepoService userRepoService;

    public UserCreatingUseCase(UserCreatingRequest request, UserRepoService userRepoService) {
        this.request = request;
        this.userRepoService = userRepoService;
    }

    @Override
    protected void validate() {
        new FieldShouldBePresent<>(request.getName(), "name").validateOrThrow();
    }

    @Override
    protected ResponseWithId process() {

        UserModel userModel = userRepoService.saveUser(new UserModel(request.getName()));

        return new ResponseWithId(userModel.getId());
    }
}
