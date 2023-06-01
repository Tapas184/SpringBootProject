package com.nt.Spring.bo;

public class PaitentBO {
    //input data for DAO class
    private String patientname;
    private String paitentaddress;
    private long paitentnumber;
    private Integer paitentncount;
    private Float billperday;
    private Float totalbillamount;
    private Float netbillamount;
    
  //getter and setter method
    
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
    public Float getBillperday() {
        return billperday;
    }
    public void setBillperday(Float billperday) {
        this.billperday = billperday;
    }
    public Float getTotalbillamount() {
        return totalbillamount;
    }
    public void setTotalbillamount(Float totalbillamount) {
        this.totalbillamount = totalbillamount;
    }
    public Float getNetbillamount() {
        return netbillamount;
    }
    public void setNetbillamount(Float netbillamount) {
        this.netbillamount = netbillamount;
    }
    @Override
    public String toString() {
	return "PaitentBO [patientname=" + patientname + ", paitentaddress=" + paitentaddress + ", paitentnumber="
		+ paitentnumber + ", paitentncount=" + paitentncount + ", billperday=" + billperday
		+ ", totalbillamount=" + totalbillamount + ", netbillamount=" + netbillamount + "]";
    }//to string method
}//Bo class
