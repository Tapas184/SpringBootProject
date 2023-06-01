package com.spring.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.spring.bean.WishMessageGenerator;

@SuppressWarnings("deprecation")
public class SetterInjectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//locate and hold spring bean confg file
		FileSystemResource res = new FileSystemResource("src/com/spring/config/application_context.xml");
		//to create IOC container
		XmlBeanFactory factory = new XmlBeanFactory(res);
		//get Target bean class object
		 Object obj = factory.getBean("wmg");
		 //type casting
		 WishMessageGenerator generator =(WishMessageGenerator)obj;
		 String result = generator.generateWishMessage("Tapas");
		 System.out.println(result);

	}

}
