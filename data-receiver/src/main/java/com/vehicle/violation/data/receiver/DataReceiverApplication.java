package com.vehicle.violation.data.receiver;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.violation.data.receiver.model.Feed;
import com.vehicle.violation.data.receiver.service.VehicleFilterService;


@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/send")
@EnableFeignClients
public class DataReceiverApplication {
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(DataReceiverApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DataReceiverApplication.class, args);
	}
	@Autowired
	private VehicleFilterService vehicleFilterService;
	
	
	@PostMapping("/feed")
	public void recieveData(@RequestBody Feed feed) {

		
		try {
			vehicleFilterService.getVehiclesFromGovernanceAndSendLocationAndVehicleDataToCommunicationServer(feed.getCameraData().getVehicleNumber(), feed.getCameraLocation());
		} catch (Exception e) {
			log.error("Error occured while sending the data to the communication server"+e.getMessage());
		}
	}
	


}
