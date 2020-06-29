package com.negocio.account.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.negocio.account.dto.AuthRequestDto;
import com.negocio.account.security.JwtUtil;

@Service
public class AuthenticationServiceImpl {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AccountDetailsServiceImpl accountDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	public String generateToken(AuthRequestDto authRequestDto) {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(),
					authRequestDto.getPassword()));
		} catch (Exception ex) {
			throw new RuntimeException("Invalid username or password");
		}

		final UserDetails userDetails = accountDetailsService.loadUserByUsername(authRequestDto.getUsername());
		return jwtUtil.generateToken(userDetails);
	}
}
