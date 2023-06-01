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
			System.out.println("===========queryForObject()===========");
			int count = service.getEmployeeCount();
			System.out.println("The Employee Count is::= "+count);
			System.out.println("=========queryForMap(sql,Object... obj)====");
			Map<String, Object> emp = service.fetchEmpById(1005);
			System.out.println(emp);
			System.out.println("============queryForList(String sql, String... deg)===========");
			service.fetchEmployeeByJob("CLERK", "MANAGER").forEach(System.out::println);
			
		}
		catch(DataAccessException e) {
			e.printStackTrace();
		}
	}

}
