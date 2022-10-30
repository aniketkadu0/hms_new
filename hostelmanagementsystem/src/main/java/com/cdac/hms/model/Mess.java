package com.cdac.hms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Mess {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String messIncharge;
	int messContactNumber;
	int price;
	@OneToOne
	Hostel hostel;
}
