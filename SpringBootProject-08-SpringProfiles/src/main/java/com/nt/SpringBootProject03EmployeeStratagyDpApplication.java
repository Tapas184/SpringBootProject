package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.EmployeeController;
import com.nt.vo.EmployeeVo;

@SpringBootApplication
public class SpringBootProject03EmployeeStratagyDpApplication {


	public static void main(String[] args) {
		//Create a scanner object
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter count of degignation ::");
		int count = sc.nextInt();
		String desg[]=null;
		if(count>=1)
			desg=new String[count]; // set array size by collecting count from end user
		else {
			System.out.println("Invalid input");
			return;
		}
		for(int i = 0;i<count;++i) {
			System.out.println("Enter degignation ::"+(i+1));
			//collect designation from end user
			String desig =sc.next();
			desig=desig.toUpperCase();
			//and add to the desg[] array
			desg[i]=desig;
		}
		ApplicationContext ctx=SpringApplication.run(SpringBootProject03EmployeeStratagyDpApplication.class, args);
		EmployeeController controller =ctx.getBean("employeeController",EmployeeController.class);
		//invoke business method
		try {
		List<EmployeeVo> vo = controller.process(desg);
		System.out.println(vo);
		}//try
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in data try after some time"+e.getMessage());
		}//catch
	}//main

}//class
