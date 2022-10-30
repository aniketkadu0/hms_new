package com.cdac.hms.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.hms.model.Room;

@Repository
public interface RoomDAO extends JpaRepository<Room, Integer>{

}
