package com.example.project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="reply")
@Table(name="reply")

public class ReplyEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "reply_idx", updatable = false)
    private Integer replyIdx;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name= "board_idx", referencedColumnName = "board_idx", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private BoardEntity replyBoardIdx;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name= "id", referencedColumnName = "id")
    private UserEntity replyUserId;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date reg_date;

    //more builder possible
    @Builder
    public ReplyEntity(String content, BoardEntity boardIdx, UserEntity userId, Date reg_date) {
        this.content = content;
        this.replyBoardIdx = boardIdx;
        this.replyUserId = userId;
        this.reg_date = reg_date;
    }

    public String getNickname() {
        if (replyUserId != null){
            return replyUserId.getNickname();
        }
        return null;
    }
}
