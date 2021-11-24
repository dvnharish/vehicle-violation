package com.vehicle.violation.data.receiver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicle.violation.data.receiver.model.VehicleViolationMessage;



@FeignClient(name = "${feign.name}")
public interface CommServiceProxy {

	@PostMapping("/alert")
	public void alertTheBeatAtLocationAboutVehiclePendingViolation(@RequestBody VehicleViolationMessage vehicleViolationMessage); 
}
