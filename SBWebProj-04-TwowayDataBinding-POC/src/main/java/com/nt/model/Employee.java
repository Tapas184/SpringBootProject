package com.nt.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Employee implements Serializable {
	private Integer eid;
	private String name;
	private Double salary;

}//end of class employee
