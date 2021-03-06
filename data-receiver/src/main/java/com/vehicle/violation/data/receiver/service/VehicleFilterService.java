package com.vehicle.violation.data.receiver.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vehicle.violation.data.receiver.DataReceiverApplication;
import com.vehicle.violation.data.receiver.model.VehicleViolation;
import com.vehicle.violation.data.receiver.model.VehicleViolationMessage;

@Service
public class VehicleFilterService {
	
	@Autowired
	private CommServiceProxy commServiceProxy;

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(DataReceiverApplication.class);

	public void getVehiclesFromGovernanceAndSendLocationAndVehicleDataToCommunicationServer(String vehicleId,
			String camaraLocation) throws URISyntaxException {
		List<VehicleViolation> listOfPendingViolationsOnAVehicle = getListOfPendingViolatedVehiclesFromGovernment(
				vehicleId);
		if (listOfPendingViolationsOnAVehicle != null) {
			sendTheDataToComminicationServer(listOfPendingViolationsOnAVehicle, camaraLocation);
		}

	}

	public List<VehicleViolation> getListOfPendingViolatedVehiclesFromGovernment(String vehicleId) {

		RestTemplate restTemplate = new RestTemplate();
		String BASE_URL = "http://localhost:9000/vehicle/violations?vehicleNumber=" + vehicleId;

		ResponseEntity<List<VehicleViolation>> responseEntity = restTemplate.exchange(BASE_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<VehicleViolation>>() {
				});

		return responseEntity.getBody();

	}
	
	

	private void sendTheDataToComminicationServer(List<VehicleViolation> vehicleViolations, String camaraLocation) throws URISyntaxException {

		VehicleViolationMessage vvMessage = new VehicleViolationMessage();

		vvMessage.setTotalPenalty(vehicleViolations.stream().mapToDouble(VehicleViolation::getPenalty).sum());
		vvMessage.setLocation(camaraLocation);
		vvMessage.setVehicleViolations(vehicleViolations);

		
//		RestTemplate restTemplate = new RestTemplate();
//	    final String baseUrl = "http://localhost:7000/alert";
//	    URI uri = new URI(baseUrl);
//	     
//	    HttpHeaders headers = new HttpHeaders();   
//	    headers.set("X-COM-LOCATION", "USA");      
//	 
//	    HttpEntity<VehicleViolationMessage> request = new HttpEntity<>(vvMessage, headers);
//	     
//	    ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
	    
	    commServiceProxy.alertTheBeatAtLocationAboutVehiclePendingViolation(vvMessage);
	    //System.out.println(result);
	    
	}

}
