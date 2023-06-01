package com.nt.Spring.vo;

public class PaitentVo {
    //gather data from end user
    private String patientname;
    private String paitentaddress;
    private String paitentnumber;
    private String paitentncount;
    private String days;
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
    public String getPaitentnumber() {
        return paitentnumber;
    }
    public void setPaitentnumber(String paitentnumber) {
        this.paitentnumber = paitentnumber;
    }
    public String getPaitentncount() {
        return paitentncount;
    }
    public void setPaitentncount(String paitentncount) {
        this.paitentncount = paitentncount;
    }
    public String getDays() {
        return days;
    }
    public void setDays(String days) {
        this.days = days;
    }
    
}
