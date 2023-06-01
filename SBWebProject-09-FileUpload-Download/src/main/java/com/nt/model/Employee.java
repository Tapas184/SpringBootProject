package com.nt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//make the class as entity/model/BO class
@Entity
@Data
@Table(name = "JOB_REG")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empno;
	@Column(length = 30)
	private String name;
	private String gender="Male";
	@Column(length = 200)
	private String resume;
	@Column(length = 200)
	private String photo;

}//end of the class Employee
