package com.mowagdy.base.domain.user.port;

import com.mowagdy.base.domain.user.model.UserModel;

import java.util.Collection;

public interface UserRepoService {

    Collection<UserModel> getAllUsers();

    Boolean isUserExists(Long id);

    UserModel getSingleUser(Long id);

    UserModel saveUser(UserModel userModel);
}
