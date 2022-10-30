package com.cdac.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.hms.DAO.MessDAO;
import com.cdac.hms.DAO.HostelDAO;
import com.cdac.hms.DAO.NoticeDAO;
import com.cdac.hms.DAO.RoomDAO;
import com.cdac.hms.DAO.RoomDetailDAO;
import com.cdac.hms.DAO.StudentDAO;
import com.cdac.hms.model.Student;
import com.cdac.hms.model.Mess;
import com.cdac.hms.model.Hostel;
import com.cdac.hms.model.Notice;
import com.cdac.hms.model.Room;
import com.cdac.hms.model.RoomDetail;

@Service
public class AdminService {

	@Autowired
	HostelDAO hostelDAO;
	@Autowired
	RoomDAO roomDAO;
	@Autowired
	MessDAO messDAO;
	@Autowired
	NoticeDAO noticeDAO;
	@Autowired
	StudentDAO studentDAO;
	@Autowired
	RoomDetailDAO roomDetailDAO;

	public Hostel addHostel(Hostel hostel) {
		return hostelDAO.save(hostel);
	}

	public Room addRoom(Room room,int qty,int firstRoomNumber){
		
		Optional<Hostel> hostel = hostelDAO.findById(room.getHostel().getHostelId());	
		Optional<RoomDetail> roomDetail = roomDetailDAO.findById(room.getRoomDetail().getRoomDetailId());
		
		room.setHostel(hostel.get());
		room.setRoomDetail(roomDetail.get());
		
		List<Room> rooms = new ArrayList<>();	
		room.setRoomNumber(firstRoomNumber);
		System.out.println(room);
				
		firstRoomNumber--;
		int i = 1;
		while( i <= qty) {
			Room newRoom = new Room(room.getRoomNumber(),
									room.getNoOfOccupants(),room.getRoomDetail(),
									room.getHostel(),room.getStudent());
			newRoom.setRoomNumber(firstRoomNumber + i);
			rooms.add(newRoom);
			i++;	
		}

		roomDAO.saveAll(rooms);
		hostel.get().setRooms(rooms);
		hostelDAO.save(hostel.get());
		return null;
	}

	public Mess addMess(Mess mess) {
		return messDAO.save(mess);
	}

	public Notice addNotice(Notice notice) {
		return noticeDAO.save(notice);
	}

	public List<Student> getStudentData() {
		return studentDAO.findAll();
	}

	public List<Hostel> getHostelData() {
		return hostelDAO.findAll();
	}

}
