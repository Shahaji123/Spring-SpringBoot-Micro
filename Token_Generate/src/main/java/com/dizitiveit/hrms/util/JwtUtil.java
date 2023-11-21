package com.dizitiveit.hrms.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${app.secret}")
	private String secret;
	//1
	public String genrateToken(String subject) {
		
		return Jwts.builder()
				.setSubject(subject)
				.setIssuer("nareshIt")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(1)))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}//method
	
	//2
	public Claims getClaims(String token) {
		return 	Jwts.parser()
		.setSigningKey(secret.getBytes())
		.parseClaimsJws(token)
		.getBody();		
	
	}//method
	
	
	//3
	public Date getExpDate(String token) {
		
		return getClaims(token).getExpiration();
	}//method
	
	//4 read Subject
	public String getUserName(String token) {
		return getClaims(token).getSubject();
		
	}//method
	
	
	//5 validate exp date
	public boolean isTokenExp(String token) {
		Date expDate=getExpDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));
	}//method
	
	//6 validate user name in token and database exp
	public boolean validateToken(String token,String userName) {
		String tokenUserName=getUserName(token);
		return (userName.equals(tokenUserName) && !isTokenExp(token));
		
	}//method
	
	
	
	

	
	
}
