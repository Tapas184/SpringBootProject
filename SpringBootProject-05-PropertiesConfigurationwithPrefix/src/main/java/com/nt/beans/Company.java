package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("company")
public class Company {
	@Value("${org.nit.tittle}")
private String CompanyName;
	@Value("${org.nit.name}")
	private String name;
	@Value("${org.nit.location}")
	private String location;
	@Override
	public String toString() {
		return "Company [CompanyName=" + CompanyName + ", name=" + name + ", location=" + location + "]";
	}


}
