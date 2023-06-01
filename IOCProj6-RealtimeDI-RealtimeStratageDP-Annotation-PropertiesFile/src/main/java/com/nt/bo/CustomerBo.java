package com.nt.bo;

public class CustomerBo {
//bean properties
    private  String custName;
    private String custAdd;
    private Integer rootAmount;
    private Float rate;
    private Integer time;
    private Float intrest;
    // getter & Setter Method
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
    public Integer getRootAmount() {
        return rootAmount;
    }
    public void setRootAmount(Integer rootAmount) {
        this.rootAmount = rootAmount;
    }
    public Float getRate() {
        return rate;
    }
    public void setRate(Float rate) {
        this.rate = rate;
    }
    public Integer getTime() {
        return time;
    }
    public void setTime(Integer time) {
        this.time = time;
    }
    public Float getIntrest() {
        return intrest;
    }
    public void setIntrest(Float intrest) {
        this.intrest = intrest;
    }
    // To string methods
    @Override
    public String toString() {
	return "CustomerBo [custName=" + custName + ", custAdd=" + custAdd + ", rootAmount=" + rootAmount + ", rate="
		+ rate + ", time=" + time + ", intrest=" + intrest + "]";
    }
    
}//class
