package com.cdac.hms.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.hms.model.Mess;

@Repository
public interface MessDAO extends JpaRepository<Mess, Integer>{

}
