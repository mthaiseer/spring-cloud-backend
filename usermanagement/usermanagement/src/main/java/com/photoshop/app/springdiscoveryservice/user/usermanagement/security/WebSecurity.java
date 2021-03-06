package com.photoshop.app.springdiscoveryservice.user.usermanagement.security;

import javax.servlet.Filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.photoshop.app.springdiscoveryservice.user.usermanagement.service.UserManagementService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserManagementService userService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/api/users/**").permitAll()
		.and()
		.addFilter(getAuthernticationFilter());
		http.headers().frameOptions().disable();
		
		
	}

	private AuthenticationFilter getAuthernticationFilter() throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(userService, env, authenticationManager());
		//authenticationFilter.setAuthenticationManager(authenticationManager());
		return authenticationFilter;
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	 

}
