package com.cdac.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.hms.model.Mess;
import com.cdac.hms.model.Concern;
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
	
	@PostMapping("/addmess")
	ResponseEntity<?> addFacility(@RequestBody Mess mess){
		try {
			Mess newMess = adminService.addMess(mess);
			return ResponseEntity.status(HttpStatus.OK).header("Mess Added").body(newMess);
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
	
	@GetMapping("/getrooms")
	ResponseEntity<?> getRooms(){
		try {
			List<Room> rooms = adminService.getRooms();
			return ResponseEntity.status(HttpStatus.OK).body(rooms);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@PutMapping("/deallocateroom")
	ResponseEntity<?> deallocateRoom(@RequestBody Room room,@RequestParam int userId){
		try {
			Room newRoom = adminService.deallocateRoom(room,userId);
			return ResponseEntity.status(HttpStatus.OK).header("Room is successfully deallocated").body(newRoom);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@GetMapping("/getnotices")
	ResponseEntity<?> getNotices(){
		try {
			List<Notice> notices = adminService.getNotices();
			return ResponseEntity.status(HttpStatus.OK).body(notices);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@PutMapping("/addresponse")
	ResponseEntity<?> addResponse(@RequestBody Concern concern){
		try {
			Concern newConcern = adminService.addResponse(concern);
			return ResponseEntity.status(HttpStatus.OK).header("Response Added").body(newConcern);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
}
