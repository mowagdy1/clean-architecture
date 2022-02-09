package com.mowagdy.base.infrastructure.user.repo;

import com.mowagdy.base.domain.user.model.UserModel;
import com.mowagdy.base.domain.user.repo.UserRepo;
import com.mowagdy.base.infrastructure.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UserRepoImpl implements UserRepo {

    private final SpringDataUserRepo userRepo;

    @Autowired
    public UserRepoImpl(SpringDataUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Collection<UserModel> getAllUsers() {
        return null;
    }

    @Override
    public Boolean isUserExists(Long id) {
        return userRepo.existsById(id);
    }

    @Override
    public UserModel getSingleUser(Long id) {
        return userRepo.getById(id).toUserModel();
    }

    @Override
    public UserModel saveUser(UserModel userModel) {
        User user = userRepo.save(new User(userModel));
        return user.toUserModel();
    }
}
