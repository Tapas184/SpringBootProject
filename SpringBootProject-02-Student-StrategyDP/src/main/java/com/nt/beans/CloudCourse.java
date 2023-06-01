package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("cloud")
public class CloudCourse implements ICourseMaterials {
	
	public CloudCourse() {
		System.out.println("CloudCousrse::0-Param constructor");
	}//

	@Override
	public String content() {
		System.out.println("CloudCousrse.content()");
		return "1.AWS, 2.AZURE, 3.CloudComputing,";
	}//content

	@Override
	public double price() {
		System.out.println("CloudCousrse.price()");
		return 3000;
	}//price

}//class
