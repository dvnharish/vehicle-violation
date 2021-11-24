package com.vehicle.violation.traffic.governance.service.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OnDutyPersonnel {

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
        
    )
    @Column(name = "id", updatable = false, nullable = false)
	private UUID  id;

	private String name;
	private DeviceType deviceType;
	private String deviceNumber;
	private String location;
	public OnDutyPersonnel(String name, DeviceType deviceType, String deviceNumber, String location) {
		this.name = name;
		this.deviceType = deviceType;
		this.deviceNumber = deviceNumber;
		this.location=location;
	}
	

}
