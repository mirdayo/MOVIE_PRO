package com.example.demo.restcontroller;

import com.example.demo.configuration.auth.CustomAuthenticationFailureHandler;
import com.example.demo.configuration.auth.CustomAuthenticationSuccessHandler;
import com.example.demo.domain.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/member")
public class MemberLoginController {

    private final AuthenticationManager authenticationManager;
    private final CustomAuthenticationSuccessHandler successHandler;
    private final CustomAuthenticationFailureHandler failureHandler;

    @Autowired
    public MemberLoginController(AuthenticationManager authenticationManager, CustomAuthenticationSuccessHandler successHandler, CustomAuthenticationFailureHandler failureHandler) {
        this.authenticationManager = authenticationManager;
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
    }

    @PostMapping("/loginrequest")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(memberDTO.getUserId(), memberDTO.getUserPw());
        try {
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            successHandler.onAuthenticationSuccess(request, response, auth);
            return "success";
        } catch (AuthenticationException e) {
            failureHandler.onAuthenticationFailure(request, response, e);
            return "fail";
        }
    }
}
