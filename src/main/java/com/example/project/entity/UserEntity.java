package com.example.project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="user")
@Table(name="user")
public class UserEntity {
    @Id
    @Column(name="id", length = 20, nullable = false, updatable = false)
    private String userId;
    @Column(name="pw", nullable = false)
    private String userPw;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 50, nullable = false, unique = true)
    private String nickname;
    @Column(length = 100, nullable = false, unique = true)
    private String email;
    @Column(name="phone_num", length = 20, nullable = false, unique = true)
    private String phoneNum;
    @Column(nullable = false, updatable = false)
    @ColumnDefault("0")
    private Boolean admin;

    @Builder
    public UserEntity(String userId, String userPw, String name, String nickname, String email, String phoneNum, Boolean admin) {
        this.userId = userId;
        this.userPw = userPw;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.phoneNum = phoneNum;
        this.admin = admin;
    }
}