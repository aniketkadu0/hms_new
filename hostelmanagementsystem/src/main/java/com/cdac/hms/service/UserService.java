package com.cdac.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.hms.DAO.RoleDAO;
import com.cdac.hms.DAO.UserDAO;
import com.cdac.hms.model.Role;
import com.cdac.hms.model.User;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Service
public class UserService {

	private Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
	
	@Autowired
	RoleDAO roleDAO;
	@Autowired
	UserDAO userDAO;

	public Role addRole(Role role) {
		return roleDAO.save(role);
	}

	public User addUser(User user) throws Exception {
		if (userDAO.findByEmailId(user.getEmailId()) == null) {
			String hashedPassword = pbkdf2PasswordEncoder.encode(user.getPassword());
			user.setPassword(hashedPassword);
	        return userDAO.save(user); 
		}
		else throw new Exception("emailId exists");
	}

	public User checkLogin(User user) throws Exception {
		User findUser = (User) userDAO.findByEmailId(user.getEmailId());
		if(findUser != null) {
			if(pbkdf2PasswordEncoder.matches(user.getPassword(), findUser.getPassword()))
				return findUser;
			else
				throw new Exception();
		}
		throw new Exception();
	}
	
}
