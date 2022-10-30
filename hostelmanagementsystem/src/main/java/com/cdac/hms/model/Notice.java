package com.cdac.hms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "notices")
public class Notice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int noticeId;
	String subject;
	String description;
	
	@OneToOne
	Hostel hostel;
}
