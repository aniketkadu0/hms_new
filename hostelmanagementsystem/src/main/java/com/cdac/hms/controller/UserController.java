package com.cdac.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.hms.model.Role;
import com.cdac.hms.model.User;
import com.cdac.hms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addrole")
	ResponseEntity<?> addRole(@RequestBody Role role) { 
		try {
			Role newRole = userService.addRole(role);
			return ResponseEntity.status(HttpStatus.OK).header("Role Added").body(newRole);
		}
		catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@PostMapping("/adduser")
	ResponseEntity<?> addUser(@RequestBody User user) {
		try {
			User newUser = userService.addUser(user);
			return ResponseEntity.status(HttpStatus.OK).header("User Added").body(newUser);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("EmailId already exists!");
		}
	}
	
	@PostMapping("/login")
	ResponseEntity<?> checkLogin(@RequestBody User user) {
		try {
			User finduser = userService.checkLogin(user);
			return ResponseEntity.status(HttpStatus.OK).header("login successfully").body(finduser);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Wrong credentials");
		}
	}
	
}
