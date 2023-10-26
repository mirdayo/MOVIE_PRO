package com.example.demo.service;

import com.example.demo.domain.dto.MemberDTO;
import com.example.demo.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityService {

    private final MemberMapper memberMapper;

    private final PasswordEncoder passwordEncoder;

    public boolean checkPassword(MemberDTO memberDTO) {

        System.out.println("userPW : " + memberDTO.getUserPw());
        // DB에서 가져온 암호화 된 비밀번호
        String nowPw = memberMapper.checkPassword(memberDTO.getUserId());
        System.out.println("nowPW : " + nowPw);

        //현재 비밀번호와 매칭
        boolean pwMatcheTrue = passwordEncoder.matches(memberDTO.getUserPw(), nowPw);
        System.out.println("pwMatcheTF : " + pwMatcheTrue);

        if(!pwMatcheTrue) {
            throw new AuthenticationServiceException("Current password is incorrect.");
        }

        return true;
    }
}
