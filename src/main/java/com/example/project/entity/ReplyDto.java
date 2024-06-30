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
@Entity(name="reply")
@Table(name="reply")

public class ReplyDto {
    @Id
    private Integer replyIdx;
    private Integer boardIdx;
    private String writer;
    private String userId;
    private String content;
    private String reg_data;
}
