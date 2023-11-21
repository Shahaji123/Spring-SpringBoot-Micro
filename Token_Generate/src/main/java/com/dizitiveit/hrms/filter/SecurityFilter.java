package com.dizitiveit.hrms.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dizitiveit.hrms.util.JwtUtil;
@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	protected void doFilterInternal(HttpServletRequest request
			,HttpServletResponse response
			,FilterChain filterChain)throws ServletException,IOException  {
		String token=request.getHeader("Authorization");
		if(token!=null) {
			String username=util.getUserName(token);
			
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails uds=userDetailsService.loadUserByUsername(username);
				boolean isValid=util.validateToken(token, uds.getUsername());
				
				if(isValid) {
					UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(username,uds.getPassword(),uds.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
			
		}
		filterChain.doFilter(request, response);
	}//method

}
