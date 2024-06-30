package com.example.project.repository;
import com.example.project.entity.UserDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends JpaRepository<UserDto, String> {

}
