package com.vehicle.violation.traffic.governance.service.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.violation.traffic.governance.service.model.VehicleViolation;

@Repository
public interface VehicleViolationReporsitory extends JpaRepository<VehicleViolation, String>{

	List<VehicleViolation> findAllByVehicleNumber(String vehicleNumber);

}
