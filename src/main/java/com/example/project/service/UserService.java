package com.example.project.service;

import com.example.project.dto.SignUpRequestDTO;
import com.example.project.entity.UserEntity;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private void checkDupeUser(SignUpRequestDTO signUpRequestDTO) {
        if(userRepository.findByEmail(signUpRequestDTO.getEmail()).isPresent()){
            throw new IllegalStateException("이미 존재하는 이메일입니다");
        }
        if(userRepository.findByUserId(signUpRequestDTO.getUserId()).isPresent()){
            throw new IllegalStateException("이미 존재하는 사용자 ID입니다");
        }
        if(userRepository.findByNickname(signUpRequestDTO.getNickname()).isPresent()){
            throw new IllegalStateException("이미 존재하는 닉네임입니다");
        }
        if(userRepository.findByPhoneNum(signUpRequestDTO.getPhoneNum()).isPresent()){
            throw new IllegalStateException("이미 존재하는 번호입니다");
        }
    }
    private void confirmPw(SignUpRequestDTO signUpRequestDTO){
        if(!signUpRequestDTO.getUserPw().equals(signUpRequestDTO.getUserPw2())){
            throw new IllegalArgumentException("비밀번호와 확인용 비밀번호가 일치하지 않습니다.");
        }
    }

    public UserEntity join(SignUpRequestDTO signUpRequestDTO){
        checkDupeUser(signUpRequestDTO);
        confirmPw(signUpRequestDTO);

        //pw encoder
        String encodedPassword = passwordEncoder.encode(signUpRequestDTO.getUserPw());
        //DTO to Entity
        UserEntity userEntity= UserEntity.builder()
                .userId(signUpRequestDTO.getUserId())
                .userPw(encodedPassword)
                .name(signUpRequestDTO.getName())
                .nickname(signUpRequestDTO.getNickname())
                .email(signUpRequestDTO.getEmail())
                .phoneNum(signUpRequestDTO.getPhoneNum())
                .admin(signUpRequestDTO.getAdmin() != null && signUpRequestDTO.getAdmin()) //check null
                .build();
        // 엔티티를 데이터베이스에 저장
        return userRepository.save(userEntity);

    }
}
