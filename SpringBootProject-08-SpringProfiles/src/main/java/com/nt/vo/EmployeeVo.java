//Employee Vo(Value Object) class
package com.nt.vo;


public class EmployeeVo {
	private String slNumber;
	private String empNo;
	private String ename;
	private String sal;
	private String job;
	public String getSlNumber() {
		return slNumber;
	}
	public void setSlNumber(String slNumber) {
		this.slNumber = slNumber;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
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
		return "EmployeeVo [slNumber=" + slNumber + ", empNo=" + empNo
				+ ", ename=" + ename + ", sal=" + sal + ", job=" + job + "]";
	}
	
}//class
