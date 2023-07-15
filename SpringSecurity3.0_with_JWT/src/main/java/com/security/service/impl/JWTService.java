package com.security.service.impl;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component("jwtService")
public class JWTService {

	public static final String key = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

	//This method is used for extract User Name from token
	public String extractUserName(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	//This method is used for extract Date From token
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	
	//generic method is used to apply the claim
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolve) {
		final Claims claims = extractAllClaims(token);
		return claimsResolve.apply(claims);
	}

	//this method is used to extract Claims object
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
	}

	//this method is used to return Token
	public String generateAuthenticationToken(String userName) {

		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userName);
	}

	//Verifying token is expired or not
	
	public boolean isExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	//for validate token
	public boolean validateToken(String token, UserDetails userDetails) {
		final String userName = extractUserName(token);
		return(userName.equals(userDetails.getUsername()) && !isExpired(token));
	}
	
	//this method us used to createJWT Token
	private String createToken(Map<String, Object> claims, String userName) {
		return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
				.signWith(getKey(), SignatureAlgorithm.HS256).compact();
	}

	private Key getKey() {
		// u can define your key here
		byte[] keyBytes = Decoders.BASE64.decode(key);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
