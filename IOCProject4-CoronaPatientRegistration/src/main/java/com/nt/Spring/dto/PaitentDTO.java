package com.nt.Spring.dto;

public class PaitentDTO {
    private String patientname;
    private String paitentaddress;
    private long paitentnumber;
    private Integer paitentncount;
    private Integer days;
    
  public Integer getDays() {
        return days;
    }
    public void setDays(Integer days) {
        this.days = days;
    }
    //setter and getter method
    public String getPatientname() {
        return patientname;
    }
    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }
    public String getPaitentaddress() {
        return paitentaddress;
    }
    public void setPaitentaddress(String paitentaddress) {
        this.paitentaddress = paitentaddress;
    }
    public long getPaitentnumber() {
        return paitentnumber;
    }
    public void setPaitentnumber(long paitentnumber) {
        this.paitentnumber = paitentnumber;
    }
    public Integer getPaitentncount() {
        return paitentncount;
    }
    public void setPaitentncount(Integer paitentncount) {
        this.paitentncount = paitentncount;
    }
//to string method
    @Override
    public String toString() {
	return "PaitentDTO [patientname=" + patientname + ", paitentaddress=" + paitentaddress + ", paitentnumber="
		+ paitentnumber + ", paitentncount=" + paitentncount + "]";
    }//to string method
    
    
}
