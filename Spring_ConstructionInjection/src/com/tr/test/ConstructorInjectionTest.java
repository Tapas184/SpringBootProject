package com.tr.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.tr.bean.Person;

public class ConstructorInjectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileSystemResource file = new FileSystemResource("src/com/tr/cfg/application_context.xml");
		//create UOC bean factory
		XmlBeanFactory xbf = new XmlBeanFactory(file);
		Person p  = (Person)xbf.getBean("cn");
		System.out.println(p);
	}

}
