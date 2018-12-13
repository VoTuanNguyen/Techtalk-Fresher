package com.microservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Controller {

	@Value("${config.variable}")
	private String welcome;

	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {
		return ResponseEntity.ok(welcome);
	}

	@GetMapping("/getinfo")
	public ResponseEntity<String> getInfoUser() {
		return ResponseEntity.ok().body("Access with " + SecurityContextHolder.getContext().getAuthentication().getName() + " - Authorities: " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
	}
}
