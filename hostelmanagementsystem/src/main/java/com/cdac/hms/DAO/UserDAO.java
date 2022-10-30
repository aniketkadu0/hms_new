package com.cdac.hms.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.hms.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{

	Object findByEmailId(String emailId);

}
