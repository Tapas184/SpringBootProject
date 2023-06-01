package com.nt.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Employee {

	private Integer empno;
	private String ename;
	private Integer sal;
	private String addrs;
	private Integer grossSal;
	private Integer netSal;
}//end of employee
