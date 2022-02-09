package com.mowagdy.base.infrastructure.user.repo;

import com.mowagdy.base.infrastructure.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataUserRepo extends JpaRepository<User, Long> {
}