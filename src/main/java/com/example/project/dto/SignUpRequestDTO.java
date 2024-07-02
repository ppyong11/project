package com.example.project.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SignUpRequestDTO {
    @NotEmpty(message = "아이디는 필수 입력 값입니다.")
    @Size(min = 4, max = 20, message = "아이디는 4자 이상 20자 이내로 입력해주세요.")
    private String userId;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이내로 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!~`<>,./?;:'\"\\[\\]{}\\\\()|_-])\\S*$", message = "비밀번호는 영문, 숫자, 특수문자가 포함되어야 합니다.")
    private String userPw;
    @NotEmpty(message = "비밀번호를 다시 입력해 주세요.")
    private String userPw2; //pw confirm

    @NotEmpty(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotEmpty(message = "닉네임은 필수 입력 값입니다.")
    @Size(max = 50, message = "닉네임은 50자 이내로 입력해주세요.")
    private String nickname;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotEmpty(message = "휴대폰 번호는 필수 입력 값입니다.")
    @Pattern(regexp = "^[0-9]{10,11}$", message = "휴대폰 번호는 10~11자리의 숫자만 가능합니다.")
    private String phoneNum;

    private Boolean admin = false; // 기본값은 일반 사용자

    // Getters and Setters
}
