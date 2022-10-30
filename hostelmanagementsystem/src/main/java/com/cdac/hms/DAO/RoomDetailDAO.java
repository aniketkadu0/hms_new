package com.cdac.hms.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.hms.model.RoomDetail;

@Repository
public interface RoomDetailDAO extends JpaRepository<RoomDetail, Integer>{

}
