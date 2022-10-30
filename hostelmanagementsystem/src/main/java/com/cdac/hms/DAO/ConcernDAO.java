package com.cdac.hms.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.hms.model.Concern;

@Repository
public interface ConcernDAO extends JpaRepository<Concern, Integer>{

}
