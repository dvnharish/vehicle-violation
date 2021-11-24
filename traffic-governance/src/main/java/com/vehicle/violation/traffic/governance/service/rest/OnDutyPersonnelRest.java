package com.vehicle.violation.traffic.governance.service.rest;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.violation.traffic.governance.service.model.OnDutyPersonnel;
import com.vehicle.violation.traffic.governance.service.model.repository.OnDutyPersonnelRepository;

@RestController
@RequestMapping("/onduty")
public class OnDutyPersonnelRest {

	@Autowired
	private OnDutyPersonnelRepository dutyPersonnelRepository;

	@GetMapping(path = "/personnel")
	public List<OnDutyPersonnel> getOnDutyPersonalAtLocation(@QueryParam(value = "location") String location) {
		return dutyPersonnelRepository.findAllByLocation(location);

	}
}
