package com.nt.vo;

public class EmployeeVO {
//VO class hold all input in string
    private String empname;
    private String empaddrs;
    private String basicsalary;
    private String grosssalary;
    private String netsalary;
    private String hramount;
    private String pfamount;
    public String getHramount() {
        return hramount;
    }
    public void setHramount(String hramount) {
        this.hramount = hramount;
    }
    public String getPfamount() {
        return pfamount;
    }
    public void setPfamount(String pfamount) {
        this.pfamount = pfamount;
    }
    //getter and setter method
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
    public String getBasicsalary() {
        return basicsalary;
    }
    public void setBasicsalary(String basicsalary) {
        this.basicsalary = basicsalary;
    }
    public String getGrosssalary() {
        return grosssalary;
    }
    public void setGrosssalary(String grosssalary) {
        this.grosssalary = grosssalary;
    }
    public String getNetsalary() {
        return netsalary;
    }
    public void setNetsalary(String netsalary) {
        this.netsalary = netsalary;
    }
    //To string method for showing any data
    @Override
    public String toString() {
	return "EmployeeVO [empname=" + empname + ", empaddrs=" + empaddrs + ", basicsalary=" + basicsalary
		+ ", grosssalary=" + grosssalary + ", netsalary=" + netsalary + ", hramount=" + hramount + ", pfamount="
		+ pfamount + "]";
    }

    
}
