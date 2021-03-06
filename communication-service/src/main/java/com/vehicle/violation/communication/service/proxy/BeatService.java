package com.vehicle.violation.communication.service.proxy;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vehicle.violation.communication.service.model.Beat;

@Service
public class BeatService {
	
	public List<Beat> getBeatPersonallsAtLocation(String location) {

		RestTemplate restTemplate = new RestTemplate();
		String BASE_URL = "http://localhost:9000/onduty/personnel?location=" + location;

		ResponseEntity<List<Beat>> responseEntity = restTemplate.exchange(BASE_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Beat>>() {
				});

		return responseEntity.getBody();

	}

}
