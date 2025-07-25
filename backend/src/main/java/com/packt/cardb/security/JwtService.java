package com.packt.cardb.security;

import java.security.Key;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
	static final long EXPIRATION_TIME = 86400000; // 1 day in ms
	static final String PREFIX = "Bearer";
	static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	// Generate signed JWT token
	public String getToken(String username) {
		String token = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(key).compact();

		return token;
	}

	// Get a token from request Authorization header, verify a token and get
	// username
	public String getAuthUser(HttpServletRequest request) {
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (token != null) {
			String user = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token.replace(PREFIX, ""))
					.getBody().getSubject();
			
			if (user != null) {
				return user;
			}
		}
		
		return null;
	}
}
