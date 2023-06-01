package com.nt.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.model.CustomerModel;
import com.nt.repogitory.ICustomerRepo;

@Service("customerService")
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerRepo repo;
	@Autowired
	private BCryptPasswordEncoder encode;

	@Override
	public String customerRegister(CustomerModel c) {
		c.setPwd(encode.encode(c.getPwd()));
		return repo.save(c).getCid() + " id is registered";
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<CustomerModel> opt = repo.findByName(username);
		if (opt.isEmpty()) {
			throw new IllegalArgumentException(username + "User not found");
		} else {
			// get the customer list
			CustomerModel customer = opt.get();
			// convert set<String> type role to Set<SimpleGrantAuthority> type role
			/*Set<SimpleGrantedAuthority> roles = new HashSet();
			for (String role : customer.getRoles()) {
				SimpleGrantedAuthority auth = new SimpleGrantedAuthority(role);
				roles.add(auth);
			}
			// convert model class object(CustomerModel) to spring security user object
			User user = new User(customer.getName(), customer.getPwd(), roles);*/
			User user=new User(customer.getName(),
					            customer.getPwd(),
					            customer.getRoles().stream().map(role-> new SimpleGrantedAuthority(role))
					            .collect(Collectors.toSet()));
			return user;
		}//else

	}//method

}//class
