package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity(name="user")
@Table(name="user")

public class UserEntity {
    @Id
    @Column(name="id", length = 20, nullable = false)
    private String userId;
    @Column(name="pw", length = 20, nullable = false)
    private String userPw;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 50, nullable = false, unique = true)
    private String nickname;
    @Column(length = 100, nullable = false, unique = true)
    private String email;
    @Column(length = 20, nullable = false, unique = true)
    private String phoneNum;
    @Column(nullable = false, updatable = false)
    @ColumnDefault("0")
    private Boolean admin;
}