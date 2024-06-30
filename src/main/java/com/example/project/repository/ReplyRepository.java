package com.example.project.repository;
import com.example.project.entity.ReplyDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyDto, Integer> {

}