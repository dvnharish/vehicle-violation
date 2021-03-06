package com.vehicle.violation.traffic.governance.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vehicle.violation.traffic.governance.service.model.DeviceType;
import com.vehicle.violation.traffic.governance.service.model.OnDutyPersonnel;
import com.vehicle.violation.traffic.governance.service.model.VehicleViolation;
import com.vehicle.violation.traffic.governance.service.model.repository.OnDutyPersonnelRepository;
import com.vehicle.violation.traffic.governance.service.model.repository.VehicleViolationReporsitory;

@SpringBootApplication
//@EnableEurekaClient
public class TrafficGovernanceApplication implements CommandLineRunner {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(TrafficGovernanceApplication.class);

	@Autowired
	private OnDutyPersonnelRepository dutyPersonnelRepository;

	@Autowired
	private VehicleViolationReporsitory vehicleViolationReporsitory;

	public static void main(String[] args) {
		SpringApplication.run(TrafficGovernanceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("Started Pushing the data to the H2");
		dutyPersonnelRepository.saveAll(Arrays.asList(
				new OnDutyPersonnel("personnel1", DeviceType.MOBILE, "9781234567", "SilkBoardTrafficSignal"),
				new OnDutyPersonnel("personnel1", DeviceType.TRANSCEIVER, "9781234567", "SilkBoardTrafficSignal"),
				new OnDutyPersonnel("personnel1", DeviceType.MIC, "9781234567", "SilkBoardTrafficSignal"),
				new OnDutyPersonnel("personnel2", DeviceType.TRANSCEIVER, "9781234567", "Electronic City"),
				new OnDutyPersonnel("personnel3", DeviceType.MOBILE, "9781234567", "BTM"),
				new OnDutyPersonnel("personnel4", DeviceType.MOBILE, "9781234567", "BTM"),
				new OnDutyPersonnel("personnel5", DeviceType.MOBILE, "9781234567", "BTM"),
				new OnDutyPersonnel("personnel6", DeviceType.MOBILE, "9781234567", "BTM")
				
				
				));
		vehicleViolationReporsitory.saveAll(
				Arrays.asList(new VehicleViolation("KA51AB1234", "Light Jump", "2020-10-10:10:10", 150.00, "BTM"),
						new VehicleViolation("KA51AB1234", "Light Jump", "2020-10-11:10:10", 150.00, "BTM"),
						new VehicleViolation("KA51AB1234", "Light Jump", "2020-10-12:10:10", 150.00, "BTM"),
						new VehicleViolation("KA51AB1245", "Light Jump", "2020-10-10:10:10", 150.00, "BTM"),
						new VehicleViolation("KA51AB1265", "Light Jump", "2020-10-10:10:10", 150.00, "BTM"),
						new VehicleViolation("KA51AB1255", "Light Jump", "2020-10-10:10:10", 150.00, "BTM")));

	}

}
