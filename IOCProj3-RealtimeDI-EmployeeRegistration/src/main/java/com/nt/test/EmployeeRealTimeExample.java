package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.EmployeeMainController;
import com.nt.vo.EmployeeVO;

public class EmployeeRealTimeExample {

    public static void main(String[] args) {

	//input from End user 
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your Name");
	String name = sc.next();
	System.out.println("Enter your Address");
	String add = sc.next();
	System.out.println("Enter Basic Salary");
	String bsalary = sc.next();
	//set data into Vo object

	EmployeeVO vo = new  EmployeeVO();
	vo.setEmpname(name);
	vo.setEmpaddrs(add);
	vo.setBasicsalary(bsalary);
	//create IOC container
	try {
	    DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
	   XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
	    reader.loadBeanDefinitions("com/nt/cfg/empContext.xml");
	    EmployeeMainController controller = factory.getBean("controller",EmployeeMainController.class);
	    String result = controller.processSalary(vo);
	    System.out.println(result);
	}//try
	catch(Exception e) {
	    e.printStackTrace();
	}//catch
	sc.close();
    }

}
