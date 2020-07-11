package com.photoshop.app.springdiscoveryservice.user.usermanagement.ui.controller;



import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photoshop.app.springdiscoveryservice.user.usermanagement.service.UserDTO;
import com.photoshop.app.springdiscoveryservice.user.usermanagement.service.UserManagementService;
import com.photoshop.app.springdiscoveryservice.user.usermanagement.shared.UserRequestModel;
import com.photoshop.app.springdiscoveryservice.user.usermanagement.shared.UserResponseModel;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserManagementService userService;
	//Logger LOGGER = Logger.getLogger(UserController.class);
	
	@GetMapping("/status/check")
	public String status() {
		return "checked success";
	}
	
	@PostMapping
	public  ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody UserRequestModel userModel) {
		
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDTO userDto =  mapper.map(userModel, UserDTO.class);
		
		UserDTO user = userService.createUser(userDto);
		System.out.println("User created : "+userDto);
		UserResponseModel userResponse  =  mapper.map(user, UserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
	}

}
