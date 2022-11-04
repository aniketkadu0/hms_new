package com.cdac.hms.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.hms.model.Room;
import com.cdac.hms.model.RoomDetail;

@Repository
public interface RoomDAO extends JpaRepository<Room, Integer>{

	List<Room> findByRoomDetail(RoomDetail roomDetail);
}
