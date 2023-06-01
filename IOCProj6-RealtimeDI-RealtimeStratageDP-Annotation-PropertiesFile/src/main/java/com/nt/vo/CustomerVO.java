package com.nt.vo;

public class CustomerVO {

    private  String custName;
    private String custAdd;
    private String rootAmount;
    private String rate;
    private String time;
    //setters and getters
    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getCustAdd() {
        return custAdd;
    }
    public void setCustAdd(String custAdd) {
        this.custAdd = custAdd;
    }
    public String getRootAmount() {
        return rootAmount;
    }
    public void setRootAmount(String rootAmount) {
        this.rootAmount = rootAmount;
    }
    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    //To string method
    @Override
    public String toString() {
	return "CustomerVO [custName=" + custName + ", custAdd=" + custAdd + ", rootAmount=" + rootAmount + ", rate="
		+ rate + ", time=" + time + "]";
    }//to string
    
}
