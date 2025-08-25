package com.smartretail.serviceauth.controller;

import com.smartretail.serviceauth.dto.AuthDtos;
import com.smartretail.serviceauth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@GetMapping("/health")
	public String health() {
		return "Auth Service is running!";
	}

	@GetMapping("/test")
	public String test() {
		return "Auth Service test endpoint - " + System.currentTimeMillis();
	}

	@GetMapping("/info")
	public String info() {
		return "Auth Service - Port: 8081, Status: UP";
	}

	@PostMapping("/register")
	public ResponseEntity<AuthDtos.AuthResponse> register(@Valid @RequestBody AuthDtos.RegisterRequest request) {
		return ResponseEntity.ok(authService.register(request));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthDtos.AuthResponse> login(@Valid @RequestBody AuthDtos.LoginRequest request) {
		return ResponseEntity.ok(authService.login(request));
	}

	@PostMapping("/refresh")
	public ResponseEntity<AuthDtos.AuthResponse> refresh(@Valid @RequestBody AuthDtos.RefreshRequest request) {
		return ResponseEntity.ok(authService.refresh(request));
	}

	@PostMapping("/logout")
	public ResponseEntity<Void> logout(@Valid @RequestBody AuthDtos.LogoutRequest request) {
		authService.logout(request);
		return ResponseEntity.ok().build();
	}
}
