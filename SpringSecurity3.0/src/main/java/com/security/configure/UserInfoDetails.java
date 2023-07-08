package com.security.configure;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.entity.SecurityEntity;


public class UserInfoDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7658810125291105389L;

	private String userName;
	private String userPass;
	private List<SimpleGrantedAuthority> authorities;
	
	
	public UserInfoDetails(SecurityEntity info) {
		 userName = info.getUserName();
		 userPass = info.getUserPass();
		 authorities = Arrays.stream(info.getRoles().split(","))
				      .map(SimpleGrantedAuthority::new)
				      .toList();
				     // .collect(Collectors.toList());
		
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return userPass;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
