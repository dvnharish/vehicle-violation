package com.vehicle.violation.traffic.governance.service.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.violation.traffic.governance.service.model.OnDutyPersonnel;

@Repository
public interface OnDutyPersonnelRepository extends JpaRepository<OnDutyPersonnel, String>{

	List<OnDutyPersonnel> findAllByLocation(String location);

	
}
