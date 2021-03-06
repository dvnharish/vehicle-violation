package com.vehicle.violation.communication.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleViolation {

	private String vehicleNumber;
	private String violationData;
	private String violationDate;
	private Double penalty;
	private String location;

}
