package com.example.project.entity;

import jakarta.persistence.*;
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

public class BoardEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "board_idx")
    private Integer boardIdx;
    @Column(name= "nickname", length = 50)
    private String writer;
    @Column(name= "id", length = 20)
    private String userId;
    @Column(length = 30, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String reg_data;
    private Boolean notice;
    private Integer hit;
    private Integer heart;
}