package com.example.project.repository;
import com.example.project.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String userEmail);
    Optional<UserEntity> findByUserId(String userId);
    Optional<UserEntity> findByNickname(String nickname);
    Optional<UserEntity> findByPhoneNum(String phoneNum);
}
