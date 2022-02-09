package com.mowagdy.base.infrastructure.user.repo;

import com.mowagdy.base.domain.user.model.User;
import com.mowagdy.base.domain.user.repo.UserRepo;
import com.mowagdy.base.infrastructure.user.entity.UserEntity;
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
    public Collection<User> getAllUsers() {
        return null;
    }

    @Override
    public Boolean isUserExists(Long id) {
        return userRepo.existsById(id);
    }

    @Override
    public User getSingleUser(Long id) {
        return userRepo.getById(id).toUser();
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = userRepo.save(new UserEntity(user));
        return userEntity.toUser();
    }
}
