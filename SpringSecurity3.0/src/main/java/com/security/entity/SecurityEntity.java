package com.security.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Data
@AllArgsConstructor
public class SecurityEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2169973668373219784L;
	
	
	public SecurityEntity() {
	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "User_Id")
	private Integer id;
	
	@Column(name = "User_Name")
	private String userName;
	
	@Column(name = "User_Password")
	private String userPass;
	
	@Column(name = "Email")
	private String userEmail;
	
	@Column(name = "Role")
	private String roles;
	

}
