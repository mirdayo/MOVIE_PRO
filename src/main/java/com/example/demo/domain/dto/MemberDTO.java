package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    //	회원 id
    private String userId;
    //	회원 pw
    private String userPw;
    //	회원 이름
    private String userName;
    //	우편번호
    private String userAddr1;
    //  주소
    private String userAddr2;
    //  상세 주소
    private String userAddr3;
    //	회원 전화번호
    private String userPhone;
    //	회원, 관리자(0,1)
    private int userRole;


}
