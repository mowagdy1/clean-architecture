package com.mowagdy.base.domain.user.usecase;

import com.mowagdy.base.domain.shared.BaseUseCase;
import com.mowagdy.base.domain.shared.dto.ResponseWithId;
import com.mowagdy.base.domain.shared.validator.FieldShouldBePresent;
import com.mowagdy.base.domain.user.dto.UserCreatingRequest;
import com.mowagdy.base.domain.user.model.UserModel;
import com.mowagdy.base.domain.user.repo.UserRepo;

public class UserCreatingUseCase extends BaseUseCase<ResponseWithId> {

    private final UserCreatingRequest request;
    private final UserRepo userRepo;

    public UserCreatingUseCase(UserCreatingRequest request, UserRepo userRepo) {
        this.request = request;
        this.userRepo = userRepo;
    }

    @Override
    protected void validate() {
        new FieldShouldBePresent<>(request.getName(), "name").validateOrThrow();
    }

    @Override
    protected ResponseWithId process() {

        UserModel userModel = userRepo.saveUser(new UserModel(request.getName()));

        return new ResponseWithId(userModel.getId());
    }
}
