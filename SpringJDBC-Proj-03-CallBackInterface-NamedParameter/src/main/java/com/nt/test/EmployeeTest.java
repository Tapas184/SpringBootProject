package com.nt.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.IEmployeeServiceInterface;

public class EmployeeTest {

	public static void main(String[] args) {
		
		//Create IOC container so required xml path location
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfg/applicationConfiguration.xml");
		//call the getbean method for check xml is well formed or not and create object dependency class and inject in to target class
		IEmployeeServiceInterface service = ctx.getBean("service",IEmployeeServiceInterface.class);
		try {
			System.out.println("================SQL Query with Named Parameter============");
			service.fetchEmployeeById(1005);
			System.out.println("=================Emp list with sqlnamed Parameter===========");
			service.fetchEmployeeByJob("CLERK", "MANAGER").forEach(System.out::println);
		}
		catch(DataAccessException e) {
			e.printStackTrace();
		}//catch
		ctx.close();//close the ioc container
	}//main

}//class
