package com.mowagdy.base.domain.user.repo;

import com.mowagdy.base.domain.user.model.UserModel;

import java.util.Collection;

public interface UserRepo {

    Collection<UserModel> getAllUsers();

    Boolean isUserExists(Long id);

    UserModel getSingleUser(Long id);

    UserModel saveUser(UserModel userModel);
}
