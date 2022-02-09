package com.mowagdy.base.domain.user.repo;

import com.mowagdy.base.domain.user.model.User;

import java.util.Collection;

public interface UserRepo {

    Collection<User> getAllUsers();

    Boolean isUserExists(Long id);

    User getSingleUser(Long id);

    User saveUser(User user);
}
