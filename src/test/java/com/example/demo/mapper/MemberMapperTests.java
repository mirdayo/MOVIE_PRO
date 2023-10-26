package com.example.demo.mapper;


import com.example.demo.domain.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class MemberMapperTests {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Test
    public void memberJoinTest() {

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setUserId("dddddd");
        memberDTO.setUserPw("test1");
        memberDTO.setUserName("test1");
        memberDTO.setUserAddr1("test1");
        memberDTO.setUserAddr2("test1");
        memberDTO.setUserAddr3("test1");
        memberDTO.setUserPhone("1222222");

        memberMapper.memberJoin(memberDTO);
    }

    @Test
    public void memberLogin(){

        MemberDTO member = new MemberDTO();

        member.setUserId("admin");
        member.setUserPw("admin");

        MemberDTO result = memberMapper.memberLogin(member);
        log.info("결과값 : " + result);
        log.info("결과값 : " + member);
    }


    @Test
    public void memberLoginTest() {
        String userId = "admin";
        String rawPassword = "admin";

        // DB에서 사용자 ID에 해당하는 회원 정보를 조회합니다.
        MemberDTO member = memberMapper.findByUserId(userId);

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
