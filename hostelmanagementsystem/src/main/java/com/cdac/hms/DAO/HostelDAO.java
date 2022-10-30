package com.cdac.hms.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.hms.model.Hostel;

@Repository
public interface HostelDAO extends JpaRepository<Hostel, Integer>{

}
