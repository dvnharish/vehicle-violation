package com.vehicle.violation.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.violation.communication.service.model.Beat;
import com.vehicle.violation.communication.service.model.DeviceType;
import com.vehicle.violation.communication.service.model.VehicleViolationMessage;
import com.vehicle.violation.communication.service.proxy.BeatService;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/alert")
public class CommunicationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunicationServiceApplication.class, args);
	}

	@Autowired
	private BeatService beatService;

	@PostMapping
	public void alertTheBeatAtLocationAboutVehiclePendingViolation(@RequestBody VehicleViolationMessage vehicleViolationMessage) {

		List<Beat> listOfBeats = getDetailsOfTheBeatAtTheLocation(vehicleViolationMessage.getLocation());
		sendInformationToChannel(listOfBeats, vehicleViolationMessage);

	}

	private void sendInformationToChannel(List<Beat> listOfBeats, VehicleViolationMessage vehicleViolationMessage) {

		listOfBeats.forEach(beat -> {
			if (beat.getDeviceType().equals(DeviceType.MOBILE.label)) {
				sendDataToMobileChannel(beat.getDeviceNumber(), vehicleViolationMessage);
			}
			if (beat.getDeviceType().equals(DeviceType.TRANSCEIVER.label)) {
				sendDataToTransChannel(beat.getDeviceNumber(), vehicleViolationMessage);
			}
			if (beat.getDeviceType().equals(DeviceType.MIC.label)) {
				sendDataToMicChannel(beat.getDeviceNumber(), vehicleViolationMessage);
			}
		});

	}

	private String sendDataToMicChannel(String deviceNumber, VehicleViolationMessage vehicleViolationMessage) {
		System.out.println(" Vehicle Violater Spotted at  " + vehicleViolationMessage.getLocation()
				+ "  Vehicle Number  " + vehicleViolationMessage.getVehicleViolations().get(0).getVehicleNumber()
				+ "  Details  " + vehicleViolationMessage.getVehicleViolations().toString());
		return " Vehicle Violater Spotted at  " + vehicleViolationMessage.getLocation() + "  Vehicle Number  "
				+ vehicleViolationMessage.getVehicleViolations().get(0).getVehicleNumber() + "  Details  "
				+ vehicleViolationMessage.getVehicleViolations().toString();
	}

	private String sendDataToTransChannel(String deviceNumber, VehicleViolationMessage vehicleViolationMessage) {
		System.out.println( " Alfa 1 Come in : Vehicle Violater Spotted at  "  + vehicleViolationMessage.getLocation() +  " Vehicle Number  " 
				+ vehicleViolationMessage.getVehicleViolations().get(0).getVehicleNumber()+  "  Details  " +vehicleViolationMessage.getVehicleViolations().toString());

		return  " Alfa 1 Come in : Vehicle Violater Spotted at  "  + vehicleViolationMessage.getLocation() +  " Vehicle Number  " 
				+ vehicleViolationMessage.getVehicleViolations().get(0).getVehicleNumber()+  "  Details  " +vehicleViolationMessage.getVehicleViolations().toString();
	}

	private String sendDataToMobileChannel(String deviceNumber, VehicleViolationMessage vehicleViolationMessage) {
		System.out.println(" Hello, Please check Vehicle Violater Spotted at  " + vehicleViolationMessage.getLocation()
				+ " Vehicle Number  " + vehicleViolationMessage.getVehicleViolations().get(0).getVehicleNumber()
				+ "  Details  " + vehicleViolationMessage.getVehicleViolations().toString());
		return " Hello, Please check Vehicle Violater Spotted at  " + vehicleViolationMessage.getLocation()
				+ " Vehicle Number  " + vehicleViolationMessage.getVehicleViolations().get(0).getVehicleNumber()
				+ "  Details  " + vehicleViolationMessage.getVehicleViolations().toString();
		

	}

	private List<Beat> getDetailsOfTheBeatAtTheLocation(String location) {
		return beatService.getBeatPersonallsAtLocation(location);

	}
}
