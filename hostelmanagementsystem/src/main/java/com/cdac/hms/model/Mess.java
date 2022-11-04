package com.cdac.hms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	int messId;
	String messType;
	String messIncharge;
	String messContactNumber;
	int price;
	int hostelId;
}
