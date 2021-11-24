package com.vehicle.violation.traffic.governance.service.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleViolation {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator"

	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	private String vehicleNumber;
	private String violationData;
	private String violationDate;
	private Double penalty;
	private String location;

	public VehicleViolation(String vehicleNumber, String violationData, String violationDate, Double penalty,
			String location) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.violationData = violationData;
		this.violationDate = violationDate;
		this.penalty = penalty;
		this.location = location;
	}

}
