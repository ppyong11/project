package com.example.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="like")
@Table(name="like")

public class LikeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "like_idx", updatable = false)
    private Integer likeIdx;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="board_idx", referencedColumnName = "board_idx", nullable = false)
    private BoardEntity likeBoardIdx;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="id", referencedColumnName = "id")
    private UserEntity likeUserId;

    @Builder
    public LikeEntity(BoardEntity boardIdx, UserEntity userId) {
        this.likeBoardIdx = boardIdx;
        this.likeUserId = userId;
    }
}