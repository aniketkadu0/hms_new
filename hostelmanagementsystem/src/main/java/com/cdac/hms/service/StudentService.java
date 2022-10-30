package com.cdac.hms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.hms.DAO.ConcernDAO;
import com.cdac.hms.DAO.InvoiceDAO;
import com.cdac.hms.DAO.NoticeDAO;
import com.cdac.hms.DAO.RoomDAO;
import com.cdac.hms.DAO.RoomDetailDAO;
import com.cdac.hms.DAO.StudentDAO;
import com.cdac.hms.DAO.UserDAO;
import com.cdac.hms.model.Concern;
import com.cdac.hms.model.Invoice;
import com.cdac.hms.model.Mess;
import com.cdac.hms.model.Notice;
import com.cdac.hms.model.Room;
import com.cdac.hms.model.RoomDetail;
import com.cdac.hms.model.Student;
import com.cdac.hms.model.User;

@Service
public class StudentService {
	
	@Autowired
	StudentDAO studentDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	RoomDAO roomDAO;
	@Autowired
	InvoiceDAO invoiceDAO;
	@Autowired
	ConcernDAO concernDAO;
	@Autowired
	NoticeDAO noticeDAO;
	@Autowired
	RoomDetailDAO roomDetailDAO;
	
	public Student addDetails(Student student) {
		return studentDAO.save(student);
	}

	public Student updateDetails(Student student) {
		Optional<User> user = userDAO.findById(student.getUser().getUserId()); 
		Student student1 = studentDAO.findByUser(user);
		student1.setUser(user.get());
		student1.setMobileNumber(student.getMobileNumber());
		student1.setAddress(student.getAddress());
		student1.setBatch(student.getBatch());
		student1.setCourse(student.getCourse());
		student1.setYear(student.getYear());
		student1.setGender(student.getGender());
		return studentDAO.save(student1);
	}
	
	public Student getStudent(int userId) {
		Optional<Student> student = studentDAO.findById(userId);
		return student.get();
	}

	public Student allocateRoom(Room room,int userId) {
		Optional<User> user = userDAO.findById(userId); 
		Student student1 = studentDAO.findByUser(user);
		
		List<Student> list = new ArrayList<>();
		list.add(student1);
		room.setStudent(list);
		room.setNoOfOccupants(room.getNoOfOccupants() + 1);
		
		student1.setRoom(room);
		return studentDAO.save(student1);
	}

	public Room getRoom(String roomName) throws Exception {
		List<Room> rooms = roomDAO.findAll();
		
		for(Room room : rooms) {
			if(room.getNoOfOccupants() < room.getRoomDetail().getMaxOccupants()) {
				return room;
			}
		}
		
		throw new Exception();
	}

	public Invoice generateInvoice(Room room, Mess mess, Student student,int amount) {
		Invoice invoice = new Invoice();
		invoice.setInvoiceDate(new Date());
		invoice.setAmountPaid(amount);
		invoice.setRoom(room);
		invoice.setMess(mess);
		invoice.setStudent(student);
		int id = invoiceDAO.save(invoice).getInvoiceId();
		invoice.setInvoiceNumber("CDAC" + (202203000 + id));
		return invoiceDAO.save(invoice);
	}

	public Concern addConcern(Concern concern) {
		return concernDAO.save(concern);
	}

	public List<Notice> getNotices() {
		return noticeDAO.findAll();
	}

	public List<RoomDetail> getPrices() {
		return roomDetailDAO.findAll();
	}

}
