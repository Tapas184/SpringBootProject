package com.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "emp")
public class Employee {

	@Id
	@GeneratedValue
	private Integer empno;
	private String ename;
	private Double sal;
}//end of employee class
