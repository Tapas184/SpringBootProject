package com.nt.bo;

public class EmployeeBO {
    //create data as per db table
    private String empname;
    private String empaddrs;
    private Float basicsalary;
    private Float grosssalary;
    private Float netsalary;
    private Float hramount;
    private Float pfamount;
    //getter and setter method
public Float getHramount() {
        return hramount;
    }
    public void setHramount(Float hramount) {
        this.hramount = hramount;
    }
    public Float getPfamount() {
        return pfamount;
    }
    public void setPfamount(Float pfamount) {
        this.pfamount = pfamount;
    }
    public String getEmpname() {
        return empname;
    }
    public void setEmpname(String empname) {
        this.empname = empname;
    }
    public String getEmpaddrs() {
        return empaddrs;
    }
    public void setEmpaddrs(String empaddrs) {
        this.empaddrs = empaddrs;
    }
    public Float getBasicsalary() {
        return basicsalary;
    }
    public void setBasicsalary(Float basicsalary) {
        this.basicsalary = basicsalary;
    }
    public Float getGrosssalary() {
        return grosssalary;
    }
    public void setGrosssalary(Float grosssalary) {
        this.grosssalary = grosssalary;
    }
    public Float getNetsalary() {
        return netsalary;
    }
    public void setNetsalary(Float netsalary) {
        this.netsalary = netsalary;
    }
    //to string method to display in string
    @Override
    public String toString() {
	return "EmployeeBO [empname=" + empname + ", empaddrs=" + empaddrs + ", basicsalary=" + basicsalary
		+ ", grosssalary=" + grosssalary + ", netsalary=" + netsalary + ", hramount=" + hramount + ", pfamount="
		+ pfamount + "]";
    }

    
}
