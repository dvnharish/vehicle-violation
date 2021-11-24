package com.vehicle.violation.data.receiver.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleViolationMessage {
	
	private List<VehicleViolation> vehicleViolations;
	private Double totalPenalty;
	private String location;

}
