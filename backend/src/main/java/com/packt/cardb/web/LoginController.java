package com.packt.cardb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardb.domain.AccountCredentials;
import com.packt.cardb.security.JwtService;

@RestController
public class LoginController {
	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authMgr;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
		// Generate token and send it in the response Authorization header
		UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentials.getUsername(),
				credentials.getPassword());

		Authentication auth = authMgr.authenticate(creds);

		// Generate token
		String jwts = jwtService.getToken(auth.getName());

		// Build response with the generated token
		return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts)
				.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization").build();
	}
}
