package com.nt.model;

import javax.persistence.Id;

import lombok.Data;

@Data
@javax.persistence.Entity
public class Person {
	@Id
	private Integer id;
	private String name;
	private String country="India";
	private String state;
	private String gender;
	private String[] hobbies=new String[] {"Music"};
	private String[] language;
	

}//end of person class
