package com.vehicle.violation.communication.service.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Beat {
	private String name;
	private String deviceType;
	private String deviceNumber;
	private String location;

	

}
