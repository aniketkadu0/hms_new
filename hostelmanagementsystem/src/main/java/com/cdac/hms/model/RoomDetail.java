package com.cdac.hms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class RoomDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int roomDetailId;
	String roomName;
	int price;
	int maxOccupants;
}
