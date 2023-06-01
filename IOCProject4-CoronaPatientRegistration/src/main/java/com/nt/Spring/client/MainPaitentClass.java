package com.nt.Spring.client;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.Spring.controller.PaitentController;
import com.nt.Spring.vo.PaitentVo;

public class MainPaitentClass {

    public static void main(String[] args) {

	//read input from End user
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Paitent Name :");
	String name = sc.next();
	System.out.println("Enter Paitent Address :");
	String address = sc.next();
	System.out.println("Enter Paitent Count :");
	String numberOfPaitent =sc.next();
	System.out.println("Enter Mobile Number :");
	String number = sc.next();
	System.out.println("Number of days in Hospital :");
	String days = sc.next();
	//create vo class object
	PaitentVo vo =new PaitentVo();
	vo.setDays(days);
	vo.setPaitentaddress(address);
	vo.setPaitentncount(numberOfPaitent);
	vo.setPaitentnumber(number);
	vo.setPatientname(name);
	//Create IOC container
	try {
	DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
	XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
	reader.loadBeanDefinitions("com/nt/Spring/cfg/paitentcontext.xml");
	PaitentController controller = factory.getBean("controller",PaitentController.class);
	String result = controller.processingPaitentData(vo);
	System.out.println(result);
	}
	catch(Exception e) {
	    e.printStackTrace();
	}
    }

}
