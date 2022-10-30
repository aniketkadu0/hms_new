package com.cdac.hms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "invoices")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int invoiceId;
	@Temporal(TemporalType.DATE)
	Date invoiceDate = new Date();
	String invoiceNumber;
	int amountPaid;
	@OneToOne
	Room room;
	@OneToOne
	Mess mess;
	@OneToOne
	Student student;
	
}
