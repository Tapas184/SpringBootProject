package com.nt.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private  String custName;
    private String custAdd;
    private Integer rootAmount;
    private Float rate;
    private Integer time;
    //setter and getter methoda
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
}
