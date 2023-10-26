package com.example.demo.mapper;

import com.example.demo.domain.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    //회원가입
    public void memberJoin(MemberDTO memberDTO);

    //아이디 중복검사
    public int idCheck(String userId);

    //로그인
    public MemberDTO memberLogin(MemberDTO memberDTO);

    public MemberDTO findByUserId(String userid);

    public MemberDTO getMember(String userId);

    public void PostPwUpdate(@Param("userId") String userId, @Param("userPw") String userPw);

    public void PostNameUpdate(@Param("userId") String userId, @Param("userName") String userName);

    public void PostPhoneUpdate(@Param("userId") String userId, @Param("userPhone") String userPhone);

    public void PostAddrUpdate(@Param("userId") String userId, @Param("userAddr1") String userAddr1, @Param("userAddr2") String userAddr2, @Param("userAddr3") String userAddr3);

    public String checkPassword(String userId);

    public void PostUserDelete(String userId);


}