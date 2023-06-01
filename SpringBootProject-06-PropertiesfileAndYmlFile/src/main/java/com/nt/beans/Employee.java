package com.nt.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component("employee")
@ConfigurationProperties(prefix = "org.nit")
public class Employee {
	private String name;
	private Integer eid;
	private String[] nickName;
	private List<String> teamMembers;
	private Set<Integer> phoneNumber;
	private Map<String,String> idNumber;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public void setNickName(String[] nickName) {
		this.nickName = nickName;
	}

	public void setTeamMembers(List<String> teamMembers) {
		this.teamMembers = teamMembers;
	}

	public void setPhoneNumber(Set<Integer> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setIdNumber(Map<String, String> idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", eid=" + eid + ", nickName=" + Arrays.toString(nickName) + ", teamMembers="
				+ teamMembers + ", phoneNumber=" + phoneNumber + ", idNumber=" + idNumber + "]";
	}
	

}
