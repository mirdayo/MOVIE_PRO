package com.example.demo.controller;

import com.example.demo.domain.dto.MemberDTO;
import com.example.demo.service.MemberService;
import com.example.demo.service.SecurityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SecurityService securityService;



    //회원가입 페이지 이동
    @GetMapping("/join")
    public void GETJoin() {

        log.info("회원가입 페이지 진입");
    }

    //로그인 페이지 이동
    @GetMapping("/login")
    public void GETLogin(){

        log.info("로그인 페이지 진입");
    }

    //회원가입서비스실행
    @PostMapping("/join")
    public String POSTJoin(MemberDTO memberDTO) {
        try{

            // 비밀번호를 BCrypt로 해싱하여 저장
            String encodedPassword = passwordEncoder.encode(memberDTO.getUserPw());
            memberDTO.setUserPw(encodedPassword);

            //회원 가입 서비스 호출
            memberService.memberJoin(memberDTO);
            //redirectAttributes.addFlashAttribute("message", "회원가입이 성공적으로 완료되었습니다.");
            return "member/login";
        }catch (Exception e){
            //redirectAttributes.addFlashAttribute("error", "회원 가입 중 오류가 발생했습니다. 다시 시도해주세요");
            return "member/join";
        }

    }

	//아이디 중복검사
	@PostMapping("/memberIdChk")
	@ResponseBody
	public String POSTmemberIdChk(String userId) throws Exception{

		int result = memberService.idCheck(userId);

//        log.info("결과값 : " + result);

        if(result != 0 ){
            return "fail";  //중복아이디 존재
        }else{
            return "success";   //중복 아이디 x
        }
	}


    //회원 정보 수정
    @GetMapping("/userInfo")
    public void userInfo() {
        log.info("마이페이지 진입");

    }

    @GetMapping("/userInfo/update")
    public String userInfoUpdate() {
        log.info("회원 정보 수정페이지 진입");

        return "member/userInfo";
    }

    @PostMapping("/userInfo/update")
    public String updateUserInfo(Principal principal, @RequestBody MemberDTO memberDTO) {
        //로그인한 유저 정보에서 Id 받아와서 저장
        String userId = principal.getName();
        memberDTO.setUserId(userId);

        //새로운 패스워드 암호화
        if(memberDTO.getUserPw() != null) {
            String encodedPassword = passwordEncoder.encode(memberDTO.getUserPw());
            memberDTO.setUserPw((encodedPassword));
        }

        memberService.updateUserInfo(memberDTO);
        System.out.println(memberDTO);

        return "member/userInfo";
    }

    @GetMapping("/passCheck")
    public void checkPassword() {
        log.info("패스워드 변경 페이지 진입");
    }

    @PostMapping("/passCheck")
    @ResponseBody
    public String PostcheckPassword(Principal principal, @RequestBody MemberDTO memberDTO) throws Exception {
        //로그인한 유저 정보에서 Id 받아와서 저장
        String userId = principal.getName();
        memberDTO.setUserId(userId);

        System.out.println(memberDTO);

        boolean result = securityService.checkPassword(memberDTO);
        System.out.println(result);

        if(!result){
            return "fail";  //패스워드 틀림
        }else{
            return "success";   //패스워드 일치
        }

    }

    //회원 탈퇴
    @GetMapping("/userInfo/delete")
    public String userInfoDelete() {
        log.info("회원탈퇴 페이지 진입");

        return "member/userInfo";
    }

    @PostMapping("/userInfo/delete")
    public String PostUserDelete(@RequestParam("userId") String userId, HttpSession session)
    {
        memberService.PostUserDelete(userId);
        //사용자 세션 종료(로그아웃)
        session.invalidate();
        return "redirect:/main";
    }


    @GetMapping("/checkLogin")
    @ResponseBody
    public Map<String, Boolean> checkLoginStatus() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isLoggedIn = authentication != null && authentication.isAuthenticated();

        Map<String, Boolean> response = new HashMap<>();
        response.put("isLoggedIn", isLoggedIn);

        return response;
    }



}