package com.security.configure;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.security.entity.SecurityEntity;
import com.security.repository.SecurityRepository;

@Component("userService")
public class UserinfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private SecurityRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<SecurityEntity> userInfo = repo.findByUserName(username);
		return userInfo.map(UserInfoDetails::new)
		        .orElseThrow(()-> new UsernameNotFoundException("User Not Found"+username));
		
	}

}
