package com.cdac.hms.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.hms.model.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role, Integer>{

}
