package com.example.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity(name="board")
@Table(name="board")

public class BoardDto {
    @Id
    private Integer boardIdx;
    private String writer;
    private String userId;
    private String title;
    private String content;
    private String reg_data;
    private Boolean notice;
    private Integer hit;
    private Integer heart;
}