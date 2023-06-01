package com.nt.normal;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncode {

	public BCryptPasswordEncoder createEndcoder() {

		BCryptPasswordEncoder coder = new BCryptPasswordEncoder();
		String pwt = coder.encode("bani");
		String pwS = coder.encode("subha");
		System.out.println(pwt);
		System.out.println(pwS);
		return coder;
	}

}
