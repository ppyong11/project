package com.example.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="board")
@Table(name="board")

public class BoardEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "board_idx", updatable = false)
    private Integer boardIdx;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name= "id", referencedColumnName = "id")
    private UserEntity boardUserId;
    @Column(length = 30, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date reg_date;
    @Column(columnDefinition = "boolean default false")
    private Boolean notice;
    @Column(name="view_count", columnDefinition = "integer default 0")
    private Integer hit;
    @Column(name="like_count", columnDefinition = "integer default 0")
    private Integer heart;

    @Builder
    public BoardEntity(UserEntity userId, String title, String content, Date reg_date, Boolean notice, Integer hit, Integer heart) {
        this.boardUserId = userId;
        this.title = title;
        this.content = content;
        this.reg_date = reg_date;
        this.notice = notice;
        this.hit = hit;
        this.heart = heart;
    }

    public String getNickname() {
        if (boardUserId != null) {
            return boardUserId.getNickname();
        }
        return null;
    }
}