package com.cdac.hms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Student {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	String mobileNumber;
	String address;
	String gender;
	String batch;
	String course;
	String year;
	
	@ManyToOne
	Room room;
	@OneToOne
	Mess mess;
	@OneToOne
	Invoice invoice;
	@OneToMany
	List<Concern> concerns;
	
}
