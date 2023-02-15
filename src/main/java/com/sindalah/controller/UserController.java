package com.sindalah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sindalah.entity.UserInfo;
import com.sindalah.service.JwtTokenGeneratorInterface;
import com.sindalah.service.UserService;
import com.sindalahException.BusinessException;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtTokenGeneratorInterface jwtGenerator;

	@PostMapping("/register")
	public ResponseEntity<?> postUser(@RequestBody UserInfo user) {
		try {
			userService.saveUser(user);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody UserInfo user) {
		try {
			if (user.getUserName() == null || user.getPassword() == null) {
				throw new BusinessException("UserName or Password is Empty");
			}
			UserInfo userData = userService.getUserByNameAndPassword(user.getUserName(), user.getPassword());
			if (userData == null) {
				throw new BusinessException("UserName or Password is Invalid");
			}
			return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
}
