package com.cdac.hms.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.hms.model.Notice;

@Repository
public interface NoticeDAO extends JpaRepository<Notice, Integer>{

}
