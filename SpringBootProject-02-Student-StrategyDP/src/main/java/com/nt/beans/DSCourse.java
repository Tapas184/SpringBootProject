package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("ds")
public class DSCourse implements ICourseMaterials {
	
	public DSCourse() {
		System.out.println("DSCousrse::0-Param constructor");
	}//

	@Override
	public String content() {
		System.out.println("DSCousrse.content()");
		return "1.Python, 2.Sclaer, 3.DS-Algorithum, 4.MicrosoftExcel, ";
	}//content

	@Override
	public double price() {
		System.out.println("DSCousrse.price()");
		return 3000;
	}//price

}//class
