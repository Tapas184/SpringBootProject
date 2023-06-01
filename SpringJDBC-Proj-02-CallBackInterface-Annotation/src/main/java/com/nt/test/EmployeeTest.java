package com.nt.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.Employee;
import com.nt.service.IEmployeeServiceInterface;

public class EmployeeTest {

	public static void main(String[] args) {
		
		//create IOC container
		ClassPathXmlApplicationContext  ctx = new ClassPathXmlApplicationContext("com/nt/cfg/applicationConfiguration.xml");
		IEmployeeServiceInterface service = ctx.getBean("service",IEmployeeServiceInterface.class);
		try {
			System.out.println("===============For single record for using callback===========");
			Employee e = service.fetchById(1005);
			System.out.println(e);
			System.out.println("===============For multiple record==============");
			service.fetchByJob("CLERK", "MANAGER").forEach(System.out::println);
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
		ctx.close();
	}//main

}//class
