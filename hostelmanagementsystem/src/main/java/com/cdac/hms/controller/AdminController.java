package com.cdac.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.hms.model.Mess;
import com.cdac.hms.DAO.HostelDAO;
import com.cdac.hms.model.Hostel;
import com.cdac.hms.model.Notice;
import com.cdac.hms.model.Room;
import com.cdac.hms.model.Student;
import com.cdac.hms.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@PostMapping("/addhostel")
	ResponseEntity<?> addHostel(@RequestBody Hostel hostel){
		try {
			Hostel newHostel = adminService.addHostel(hostel);
			return ResponseEntity.status(HttpStatus.OK).header("Hostel Added").body(newHostel);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@PostMapping("/addroom")
	ResponseEntity<?> addRoom(@RequestBody Room room,@RequestParam int qty,
			@RequestParam int firstRoomNumber){
		try {
			Room newRoom = adminService.addRoom(room,qty,firstRoomNumber);
			return ResponseEntity.status(HttpStatus.OK).header("Room Added").body(newRoom);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@PostMapping("/addfacility")
	ResponseEntity<?> addFacility(@RequestBody Mess mess){
		try {
			Mess newMess = adminService.addMess(mess);
			return ResponseEntity.status(HttpStatus.OK).header("Facility Added").body(newMess);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@PostMapping("/addnotice")
	ResponseEntity<?> addNotice(@RequestBody Notice notice){
		try {
			Notice newNotice = adminService.addNotice(notice);
			return ResponseEntity.status(HttpStatus.OK).header("Notice Added").body(newNotice);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@PostMapping("/addmess")
	ResponseEntity<?> addMess(@RequestBody Mess mess){
		try {
			Mess newMess = adminService.addMess(mess);
			return ResponseEntity.status(HttpStatus.OK).header("Notice Added").body(newMess);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@GetMapping("/getstudentdata")
	ResponseEntity<?> getStudentData(){
		try {
			List<Student> students = adminService.getStudentData();
			return ResponseEntity.status(HttpStatus.OK).body(students);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@GetMapping("/gethosteldata")
	ResponseEntity<?> getHostelData(){
		try {
			List<Hostel> hostel = adminService.getHostelData();
			return ResponseEntity.status(HttpStatus.OK).body(hostel);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
}
