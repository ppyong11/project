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
@Entity(name="user")
@Table(name="user")

public class UserDto {
    @Id
    private String userId;
    private String pw;
    private String name;
    private String nickname;
    private String email;
    private String phoneNum;
    private Boolean admin;
}