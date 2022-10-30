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

import com.cdac.hms.model.Concern;
import com.cdac.hms.model.Invoice;
import com.cdac.hms.model.Mess;
import com.cdac.hms.model.Notice;
import com.cdac.hms.model.Room;
import com.cdac.hms.model.RoomDetail;
import com.cdac.hms.model.Student;
import com.cdac.hms.service.StudentService;
import com.cdac.hms.service.UserService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	UserService userService;
	
	@PostMapping("/adddetails")
	ResponseEntity<?> addDetails(@RequestBody Student student){
		try {
			Student newStudent = studentService.addDetails(student);
			return ResponseEntity.status(HttpStatus.OK).header("Student Detail Added").body(newStudent);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@PutMapping("/updatedetails")
	ResponseEntity<?> updateDetails(@RequestBody Student student){
		try {
			Student updateStudent = studentService.updateDetails(student);
			return ResponseEntity.status(HttpStatus.OK).header("Student Detail Updated").body(updateStudent);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@GetMapping("/getstudent")
	ResponseEntity<?> getStudent(@RequestParam int userId){
		try {
			Student student = studentService.getStudent(userId);
			return ResponseEntity.status(HttpStatus.OK).body(student);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@GetMapping("getprices")
	ResponseEntity<?> getPrices(){
		try {
			List<RoomDetail> roomDetails = studentService.getPrices();
			return ResponseEntity.status(HttpStatus.OK).header("Room found").body(roomDetails);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@GetMapping("getroom")
	ResponseEntity<?> getRoom(@RequestParam String roomName){
		try {
			Room Room = studentService.getRoom(roomName);
			return ResponseEntity.status(HttpStatus.OK).header("Room found").body(Room);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@PostMapping("/allocateroom")
	ResponseEntity<?> allocateRoom(@RequestBody Room room,@RequestParam int userId){
		try {
			Student newStudent = studentService.allocateRoom(room,userId);
			return ResponseEntity.status(HttpStatus.OK).header("Room is successfully allocated to student").body(newStudent);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@PostMapping("/makepayment")
	ResponseEntity<?> makePayment(@RequestBody Room room,@RequestBody Mess mess,
			@RequestBody Student student,@RequestParam int amount){
		try {
			Invoice invoice = studentService.generateInvoice(room,mess,student,amount);
			return ResponseEntity.status(HttpStatus.OK).header("Invoice in created").body(invoice);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@PostMapping("/addconcern")
	ResponseEntity<?> addConcern(@RequestBody Concern concern){
		try {
			Concern newConcern = studentService.addConcern(concern);
			return ResponseEntity.status(HttpStatus.OK).header("Concern sent").body(newConcern);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@GetMapping("/getnotices")
	ResponseEntity<?> getNotices(){
		try {
			List<Notice> notices = studentService.getNotices();
			return ResponseEntity.status(HttpStatus.OK).body(notices);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
}
