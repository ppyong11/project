package com.example.project.controller;

import com.example.project.dto.SignUpRequestDTO;
import com.example.project.dto.SignUpResponseDTO;
import com.example.project.entity.UserEntity;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDTO> signUp(@Valid @RequestBody SignUpRequestDTO signUpRequestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            UserEntity userEntity = userService.join(signUpRequestDTO);
            SignUpResponseDTO responseDTO = new SignUpResponseDTO(userEntity.getNickname(), "회원가입이 성공적으로 완료되었습니다.");
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(new SignUpResponseDTO(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new SignUpResponseDTO(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new SignUpResponseDTO(null, "회원가입 중 오류가 발생했습니다."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //회원 수정하기 전 비밀번호 확인
    @GetMapping("/checkPw")
    public String checkPwView() {
        return "member/checkPw";
    }
}

