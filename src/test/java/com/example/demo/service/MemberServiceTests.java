package com.example.demo.service;

import com.example.demo.domain.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@Slf4j
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //로그인 테스트
    @Test
    public void memberLogin(){

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setUserId("admin");
        memberDTO.setUserPw("admin");

        memberService.memberLogin(memberDTO);
        log.info("결과 값 : " + memberService.memberLogin(memberDTO));
    }

    //아이디 중복검사
    @Test
    public void idCheck(){

        String id = "admin";
        String id2 = "encoding0";
        memberService.idCheck(id);
        memberService.idCheck(id2);

        log.info("결과 값 : " +memberService.idCheck(id) );
        log.info("결과 값 : " +memberService.idCheck(id2) );
    }

    @Test
    public void memberLoginTest() {
        String userId = "test1";
        String rawPassword = "1234";

        // DB에서 사용자 ID에 해당하는 회원 정보를 조회합니다.
        MemberDTO member = memberService.findByUserId(userId);

        // 회원 정보가 존재하지 않거나 비밀번호가 일치하지 않는 경우 실패 메시지를 출력합니다.
        if (member == null || !passwordEncoder.matches(rawPassword, member.getUserPw())) {
            System.out.println("로그인 실패: 잘못된 사용자 ID 또는 비밀번호");
            return;
        }

        // 로그인 성공 메시지 및 회원 정보(비밀번호 제외)를 출력합니다.
        System.out.println("로그인 성공: " + member.getUserId());
        System.out.println("로그인 성공: " + member);
    }


}
