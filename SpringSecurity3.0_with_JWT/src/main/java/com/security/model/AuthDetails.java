package com.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthDetails {

	private String userName;
	private String userPass;
}
