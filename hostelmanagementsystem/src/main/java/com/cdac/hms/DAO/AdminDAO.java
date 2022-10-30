package com.cdac.hms.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.hms.model.Student;
import com.cdac.hms.model.User;

@Repository
public interface AdminDAO extends JpaRepository<Student, Integer>{

	Student findByUser(Optional<User> user);

}
