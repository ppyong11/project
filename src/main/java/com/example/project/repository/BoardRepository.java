package com.example.project.repository;
import com.example.project.entity.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository extends JpaRepository<BoardDto, Integer> {
}
