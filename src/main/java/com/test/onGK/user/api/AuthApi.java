package com.test.onGK.user.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.test.onGK.jwt.JwtTokenUtil;
import com.test.onGK.user.User;

@RestController
public class AuthApi {
	@Autowired
	AuthenticationManager authManager;
	
	 @Autowired JwtTokenUtil jwtUtil;

	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			Authentication authentication = authManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

			User user = (User) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			AuthResponse response = new AuthResponse(user.getEmail(), accessToken);

			return ResponseEntity.ok().body(response);

		} catch (BadCredentialsException ex) {
			System.out.println("bad");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("not found");
			//return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}