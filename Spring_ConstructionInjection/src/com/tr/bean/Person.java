package com.tr.bean;

public class Person {
	private int pid;
	private String name;
	private String address;
	private float income;
	
//create constructor using 4 parameter.
	public Person(int pid, String name, String address, float income) {
		this.pid = pid;
		this.name = name;
		this.address = address;
		this.income = income;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", address=" + address + ", income=" + income + "]";
	}
	

}
