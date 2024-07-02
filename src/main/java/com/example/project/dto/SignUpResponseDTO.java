package com.example.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    private String nickname;
    private String message;

    public SignUpResponseDTO(String nickname, String message) {
        this.nickname = nickname;
        this.message = message;
    }
}
