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
@Entity(name="reply")
@Table(name="reply")

public class ReplyEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "reply_idx")
    private Integer replyIdx;
    private Integer boardIdx;
    private String writer;
    private String userId;
    private String content;
    private String reg_data;
}
