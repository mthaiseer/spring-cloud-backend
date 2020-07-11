package com.photoshop.app.springdiscoveryservice.user.usermanagement.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.photoshop.app.springdiscoveryservice.user.usermanagement.service.UserDTO;
import com.photoshop.app.springdiscoveryservice.user.usermanagement.service.UserManagementService;
import com.photoshop.app.springdiscoveryservice.user.usermanagement.shared.LoginRequestModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	
	private UserManagementService userService;
	private Environment env;

	@Autowired
	public AuthenticationFilter(UserManagementService userService, Environment env,
			AuthenticationManager authenticationManager) {
		this.env = env;
		this.userService = userService;
		super.setAuthenticationManager(authenticationManager);
		
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			LoginRequestModel cred = new ObjectMapper().readValue(request.getInputStream(), LoginRequestModel.class);
			
			return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(cred.getEmail()
					, cred.getPassword(), new ArrayList<>()));
			
		}catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		
		String userName =  ((User)auth.getPrincipal()).getUsername();
		UserDTO userDetails = userService.loadUserByEmail(userName);
		
		String token = Jwts.builder()
		  .setSubject(userDetails.getUserId())
		  .setExpiration(new Date(System.currentTimeMillis()+ Long.parseLong(env.getProperty("token.expiration.time"))))
		  .signWith(SignatureAlgorithm.HS512, env.getProperty("jwt.secret.key"))
		  .compact();
		  
		response.addHeader("token", token);
		response.addHeader("userId", userDetails.getUserId());
		
	}
	
}
