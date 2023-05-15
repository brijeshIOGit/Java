package com.scaler.blogapi.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByUserName(String username);
    UserEntity findByEmail(String email);
}
