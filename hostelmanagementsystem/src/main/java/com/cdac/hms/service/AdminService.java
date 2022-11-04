package com.cdac.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.hms.DAO.MessDAO;
import com.cdac.hms.DAO.ConcernDAO;
import com.cdac.hms.DAO.HostelDAO;
import com.cdac.hms.DAO.NoticeDAO;
import com.cdac.hms.DAO.RoomDAO;
import com.cdac.hms.DAO.RoomDetailDAO;
import com.cdac.hms.DAO.StudentDAO;
import com.cdac.hms.DAO.UserDAO;
import com.cdac.hms.model.Student;
import com.cdac.hms.model.User;
import com.cdac.hms.model.Mess;
import com.cdac.hms.model.Concern;
import com.cdac.hms.model.Hostel;
import com.cdac.hms.model.Notice;
import com.cdac.hms.model.Room;
import com.cdac.hms.model.RoomDetail;

@Service
public class AdminService {

	@Autowired
	UserDAO userDAO;
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
	@Autowired
	ConcernDAO concernDAO;

	public Hostel addHostel(Hostel hostel) {
		return hostelDAO.save(hostel);
	}

	public Room addRoom(Room room,int qty,int firstRoomNumber){
			
		Optional<RoomDetail> roomDetail = roomDetailDAO.findById(room.getRoomDetail().getRoomDetailId());
		
		room.setRoomDetail(roomDetail.get());
		
		List<Room> rooms = new ArrayList<>();	
		
		room.setRoomNumber(firstRoomNumber);
				
		firstRoomNumber--;
		int i = 1;
		while( i <= qty) {
			Room newRoom = new Room(room.getRoomNumber(),
									room.getNoOfOccupants(),room.getRoomDetail(),
									room.getHostelId(),room.getUsers());
			newRoom.setRoomNumber(firstRoomNumber + i);
			rooms.add(newRoom);
			i++;	
		}
		
		roomDAO.saveAll(rooms);
		return rooms.get(0);
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
	
	public List<Room> getRooms() {
		return roomDAO.findAll();
	}

	public Room deallocateRoom(Room room, int userId) {
		Optional<User> user = userDAO.findById(userId); 
		Student student1 = studentDAO.findByUser(user);
		
		List<User> list = new ArrayList<>();

		list.addAll(room.getUsers());
		list.removeIf(user1 -> user1.getUserId() == userId);
		
		room.setUsers(list);
		room.setNoOfOccupants(room.getNoOfOccupants() - 1);
		
		student1.setRoom(null);
		
		return roomDAO.save(room);
	}

	public List<Notice> getNotices() {
		return noticeDAO.findAll();
	}

	public Concern addResponse(Concern concern) {
		return concernDAO.save(concern);
	}

}
