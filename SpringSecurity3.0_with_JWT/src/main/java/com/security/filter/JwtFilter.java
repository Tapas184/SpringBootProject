package com.security.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security.configure.UserinfoUserDetailsService;
import com.security.service.impl.JWTService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * This class is used to extract User name  from Token and verify whether the user is present in DB or not
 * @author user
 *
 */
@Component("jwtFilter")
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JWTService jwtservice;

	@Autowired
	private UserinfoUserDetailsService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 String userName=null;
		String header = request.getHeader("Authorization");
		if(header!=null && header.startsWith("Bearer ")) {
			String token = header.substring(7);
			 userName = jwtservice.extractUserName(token);
		}//if
		
		if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = userService.loadUserByUsername(userName);
			
			if(jwtservice.validateToken(header, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authToken);
			}//if
		}//if
		
		filterChain.doFilter(request, response);
	}//method

}
