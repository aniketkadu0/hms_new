package com.cdac.hms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
@Table(name = "hostels")
public class Hostel implements Cloneable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int hostelId;
	String hostelName;
	String hostelAddress;
	String contactPersonName;
	String contactPersonNumber;
	
	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(joinColumns = @JoinColumn(
//            name = "hostel_id",
//            referencedColumnName = "hostelId"
//    ),
//    inverseJoinColumns = @JoinColumn(
//            name = "room_number",
//            referencedColumnName = "roomNumber"
//    ))
	@JoinColumn(
	  name = "hostelId",
	  referencedColumnName = "hostelId")
	List<Room> rooms;
	
	@OneToMany
	@JoinColumn(
	  name = "hostelId",
	  referencedColumnName = "hostelId")
	List<Mess> mess;
	
	@OneToMany
	@JoinColumn(
	  name = "hostelId",
	  referencedColumnName = "hostelId")
	List<Notice> notices;
	
}
