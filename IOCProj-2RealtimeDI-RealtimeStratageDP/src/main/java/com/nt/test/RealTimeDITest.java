package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class RealTimeDITest {

    public static void main(String[] args) {

	//read input from end user
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Customer Name ::");
	String name = sc.next();
	System.out.println("Enter address ::");
	String custAdd = sc.next();
	System.out.println("Enter Time(In Month) ::");
	String time = sc.next();
	System.out.println("Enter Rate of Intrest ::");
	String rateIntrest = sc.next();
	System.out.println("Enter your amount");
	String pAmount = sc.next();
	
	//Create customer class VO object
	CustomerVO vo = new CustomerVO();
	vo.setCustName(name);
	vo.setCustAdd(custAdd);
	vo.setRate(rateIntrest);
	vo.setRootAmount(pAmount);
	vo.setTime(time);
	//create IOC container
	DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
	XmlBeanDefinitionReader reader= new XmlBeanDefinitionReader(factory);
	reader.loadBeanDefinitions("com/nt/cfg/applicationContext.xml");
	//get Controller class
	MainController controller = factory.getBean("controller",MainController.class);
	try {
	    String result = controller.processCustomer(vo);
	    System.out.println(result);
	}
	catch(Exception e) {
	    System.out.println("Error in registoring::--"+e.getMessage());
	}
    }

}
