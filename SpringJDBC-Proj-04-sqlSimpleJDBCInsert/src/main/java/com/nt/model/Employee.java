package com.nt.model;

public class Employee {
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	
	
	
	public Employee() {
		System.out.println("0- Param Constructor");
	}
	public Employee(Integer empno, String ename, String job, Double sal) {
		System.out.println("Employee.4-Param Constructor");
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
	}
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + "]";
	}
	

}
