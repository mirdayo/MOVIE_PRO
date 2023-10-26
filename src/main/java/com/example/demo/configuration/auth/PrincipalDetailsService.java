package com.example.demo.configuration.auth;


import com.example.demo.domain.dto.MemberDTO;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private MemberService memberService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if(username == null || username.isEmpty()){
			throw new UsernameNotFoundException("Username is empty");
		}

		MemberDTO memberDTO = memberService.getMember(username);

		if( memberDTO == null){
			throw new UsernameNotFoundException("Could not find user");
		}

		PrincipalDetails principal = new PrincipalDetails();
		principal.setDto(memberDTO);

		System.out.println("Loaded user details: " + principal);

		return principal;

	}

}
