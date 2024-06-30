package com.example.project.repository;

import com.example.project.entity.LikeDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikeDto, Integer> {

}
