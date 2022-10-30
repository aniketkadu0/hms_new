package com.cdac.hms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "rooms")
public class Room {
	
	@Id
	int roomNumber;
	int noOfOccupants;
	@OneToOne
	RoomDetail roomDetail;
	@OneToOne
	Hostel hostel;
	@OneToMany
	List<Student> student;
	
}
