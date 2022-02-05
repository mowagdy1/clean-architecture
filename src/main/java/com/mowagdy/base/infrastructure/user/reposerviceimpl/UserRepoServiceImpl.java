package com.mowagdy.base.infrastructure.user.reposerviceimpl;

import com.mowagdy.base.domain.user.model.UserModel;
import com.mowagdy.base.domain.user.port.UserRepoService;
import com.mowagdy.base.infrastructure.user.entity.User;
import com.mowagdy.base.infrastructure.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserRepoServiceImpl implements UserRepoService {

    private final UserRepo userRepo;

    @Autowired
    public UserRepoServiceImpl(UserRepo userRepo) {
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
