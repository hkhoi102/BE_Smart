package com.smartretail.serviceauth.client;

import com.smartretail.serviceauth.dto.AuthDtos;
import com.smartretail.serviceauth.client.dto.UserDtos;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class UserServiceClient {
	private final RestTemplate restTemplate;
	private static final String BASE_URL = "http://user-service/api/users";

	public UserServiceClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public UserDtos.UserInfo register(AuthDtos.RegisterRequest request) {
		try {
			ResponseEntity<UserDtos.UserInfo> response = restTemplate.postForEntity(BASE_URL + "/register", request, UserDtos.UserInfo.class);
			return response.getBody();
		} catch (HttpClientErrorException e) {
			throw new IllegalArgumentException(e.getResponseBodyAsString());
		}
	}

	public UserDtos.UserInfo verify(AuthDtos.LoginRequest request) {
		try {
			ResponseEntity<UserDtos.UserInfo> response = restTemplate.postForEntity(BASE_URL + "/verify", request, UserDtos.UserInfo.class);
			return response.getBody();
		} catch (HttpClientErrorException e) {
			throw new IllegalArgumentException("Invalid credentials");
		}
	}
}
