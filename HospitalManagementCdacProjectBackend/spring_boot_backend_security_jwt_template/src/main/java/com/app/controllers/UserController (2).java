package com.app.controllers;

import javax.annotation.security.PermitAll;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.EmployeeUserDto;
import com.app.dtos.Response;
import com.app.entities.User;
import com.app.services.UserServices;

@CrossOrigin
	@RestController
	@PermitAll 
	@RequestMapping("/user")
	public class UserController {
		@Autowired
		UserServices  services;
		
		
		//@Autowired
//	    private JWTUtility jwtUtility;
//
//	    @Autowired
//	    private AuthenticationManager authenticationManager;
//
//	    @Autowired
//	    private UserDetailsService userService;
	    
	  
		//
	  
//		@PostMapping("/authenticate")
//		public ResponseEntity<?> authenticateUser(@RequestBody EmployeeUserDto useData) throws Exception { 
//			
//			//token generation code 
//			try {
//	            authenticationManager.authenticate(
//	                    new UsernamePasswordAuthenticationToken(
//	                    		useData.getEmail(),
//	                    		useData.getPassword()
//	                    )
//	            );
//	        } catch (BadCredentialsException e) {
//	            throw new Exception("INVALID_CREDENTIALS", e);
//	        }
//
//	        final UserDetails userDetails
//	                = userService.loadUserByUsername(useData.getEmail());
//
//	        final String token =
//	                jwtUtility.generateToken(userDetails);
//
//			
//			EmployeeUserDataBacking user=services.getUserByEmailAndPassword(useData);
//			if(user!=null) {
//				if(user.getPassword()!=null&&user.getPassword().equals(useData.getPassword())) {
//					user.setToken(token);
//					return Response.success(user);
//				}
//					
//				return Response.error("invalid_password");
//			}
//			else
//			return Response.error("invalid_user");
//			
//		}
		@PostMapping("")
		public ResponseEntity<?> checkIfEmailExists(@RequestBody EmployeeUserDto useData ){
			Boolean emailExists=services.checkIfEmailExists(useData);
			if(emailExists==true)
			return Response.success("DUPLICATE_EMAIL");
			else
			return Response.success("UNIQUE_EMAIL");
		}
		
		@PostMapping("/validateSecurityAnswer")
		public ResponseEntity<?> checkIfUserExistByEmailAndSecurity(@RequestBody EmployeeUserDto useData ){
			Boolean emailExists=services.checkByEmailAndSecurity(useData);
			if(emailExists==true)
			return Response.success("VALID");
			else
			return Response.success("INVALID");
		}
		@PostMapping("/updatePassword")
		public ResponseEntity<?> updatePassword(@RequestBody EmployeeUserDto useData ){
			Boolean emailExists=services.updatePassword(useData);
			if(emailExists==true)
			return Response.success("PASSWORD_CHANGED");
			else
			return Response.success("INVALID");
		}
		
		

	}

