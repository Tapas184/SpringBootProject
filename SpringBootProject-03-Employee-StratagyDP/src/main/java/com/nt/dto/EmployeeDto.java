//Employee Dto(Data Transfer object)
package com.nt.dto;

import java.io.Serializable;


public class EmployeeDto implements Serializable {
	private Integer slNumber;
	private Integer empNo;
	private String ename;
	private Double sal;
	private String job;
	public Integer getSlNumber() {
		return slNumber;
	}
	public void setSlNumber(Integer slNumber) {
		this.slNumber = slNumber;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "EmployeeDto [slNumber=" + slNumber + ", empNo=" + empNo + ", ename=" + ename + ", sal=" + sal + ", job="
				+ job + "]";
	}

}//class
