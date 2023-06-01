package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EmployeeDetails {
	private String name;
	private String gender;
	private MultipartFile resume;
	private MultipartFile photo;
	

}//end of class EmployeeDetails
