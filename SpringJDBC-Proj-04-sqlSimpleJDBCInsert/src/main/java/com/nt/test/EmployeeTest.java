package com.nt.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.Employee;
import com.nt.service.IEmployeeServiceInterface;

public class EmployeeTest {

	public static void main(String[] args) {
		
		//Create IOC container so required xml path location
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfg/applicationConfiguration.xml");
		//call the getbean method for check xml is well formed or not and create object dependency class and inject in to target class
		IEmployeeServiceInterface service = ctx.getBean("service",IEmployeeServiceInterface.class);
		try {
			System.out.println(service.registerEmployee(new Employee(1250, "Harisankar", "MANAGER", 170055.0)));
		}
		catch(DataAccessException e) {
			e.printStackTrace();
		}//catch
		ctx.close();//close the ioc container
	}//main

}//class
