package com.vehicle.violation.traffic.governance.service.rest;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.violation.traffic.governance.service.model.VehicleViolation;
import com.vehicle.violation.traffic.governance.service.model.repository.VehicleViolationReporsitory;

@RestController
@RequestMapping("/vehicle")
public class VehicleViolationRest {

	@Autowired
	private VehicleViolationReporsitory vehicleViolationReporsitory;

	@GetMapping(path = "/violations")
	public ResponseEntity<List<VehicleViolation> > getOnDutyPersonalAtLocation(@PathParam(value = "vehicleNumber")  String vehicleNumber) {
		List<VehicleViolation> findAllByVehicleNumber = vehicleViolationReporsitory.findAllByVehicleNumber(vehicleNumber);

		
		
		return findAllByVehicleNumber.isEmpty()?  ResponseEntity.noContent().build():ResponseEntity.ok(findAllByVehicleNumber);

	}
}
