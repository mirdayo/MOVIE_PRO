package com.example.demo.service;

import com.example.demo.domain.dto.MemberDTO;
import com.example.demo.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    //회원가입
    public void memberJoin(MemberDTO memberDTO) {

        memberMapper.memberJoin(memberDTO);

    }

    //아이디 중복 조회
    public int idCheck(String userId) {
        return memberMapper.idCheck(userId);
    }

    //로그인
    public MemberDTO memberLogin(MemberDTO memberDTO) {
        return memberMapper.memberLogin(memberDTO);
    }

    //로그인
    public MemberDTO findByUserId(String userid){
        return memberMapper.findByUserId(userid);
    }

    public MemberDTO getMember(String userId){
        return memberMapper.getMember(userId);
    }

    public String updateUserInfo(MemberDTO memberDTO) {

        if (memberDTO.getUserPw() != null) {
            // PW 업데이트 로직
            PostPwUpdate(memberDTO.getUserId(), memberDTO.getUserPw());
        }

        if (memberDTO.getUserName() != null) {
            // 이름 업데이트 로직
            PostNameUpdate(memberDTO.getUserId(), memberDTO.getUserName());
        }

        if (memberDTO.getUserPhone() != null) {
            // 휴대폰 번호 업데이트 로직
            PostPhoneUpdate(memberDTO.getUserId(), memberDTO.getUserPhone());
        }

        if (memberDTO.getUserAddr1() != null && memberDTO.getUserAddr2() != null) {
            // 주소 업데이트 로직
            PostAddrUpdate(memberDTO.getUserId() , memberDTO.getUserAddr1(), memberDTO.getUserAddr2(), memberDTO.getUserAddr3());
        }
        return null;
    }

    public void PostPwUpdate(@Param("userId") String userId, @Param("userPw") String userPw) {
        memberMapper.PostPwUpdate(userId, userPw);
    }

    public void PostNameUpdate(@Param("userId") String userId, @Param("userName") String userName) {
        memberMapper.PostNameUpdate(userId, userName);
    }

    public void PostPhoneUpdate(@Param("userId") String userId, @Param("userPhone") String userPhone) {
        memberMapper.PostPhoneUpdate(userId, userPhone);
    }

    public void PostAddrUpdate(@Param("userId") String userId, @Param("userAddr1") String userAddr1, @Param("userAddr2") String userAddr2, @Param("userAddr3") String userAddr3) {
        memberMapper.PostAddrUpdate(userId, userAddr1, userAddr2, userAddr3);
    }

    public void PostUserDelete(String userId) {
        memberMapper.PostUserDelete(userId);
    }





}