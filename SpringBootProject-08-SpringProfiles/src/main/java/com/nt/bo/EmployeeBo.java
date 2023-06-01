//Employee Bo class data type as per data base recommended
package com.nt.bo;

public class EmployeeBo {
	private Integer empNo;
	private String ename;
	private Double sal;
	private String job;
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
		return "EmployeeBo [empNo=" + empNo + ", ename=" + ename + ", sal=" + sal + ", job=" + job + "]";
	}

}//class
