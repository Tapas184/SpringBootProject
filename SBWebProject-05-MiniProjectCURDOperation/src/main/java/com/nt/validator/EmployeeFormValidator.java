package com.nt.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.EmployeeModel;

// This class for form validation from server side
@Component
public class EmployeeFormValidator implements Validator {

	@Override
	//this method will check whether the handler method is passing correct command  class or not
	//if passed it called internally validate method otherwise it throws exception
	public boolean supports(Class<?> clazz) {
		//this method will check the parameter class is equals to caller class or not is not 
		//thren method will not execute validator
		//return EmployeeModel.class==clazz;
		return clazz.isAssignableFrom(EmployeeModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//object to employee class casting
		EmployeeModel empl=(EmployeeModel)target;
		//server side validation logic
		if(empl.getEname().isEmpty())
			errors.rejectValue("ename","emp.name.required");
		else if(empl.getEname().length()<5)
			//error message for checking Name length is greater than 5 or not
			errors.rejectValue("ename", "emp.name.minlength");
		else if(empl.getSal()==null)
			//for checking salary field is not null or not
			errors.rejectValue("sal", "emp.salary.required");
		else if(empl.getSal().isNaN())
			//checking salary  is number or not
			errors.rejectValue("sal", "emp.salary.required");
		else if(empl.getSal()<10000)
			//check salary is more then 10000 or not
			errors.rejectValue("sal", "emp.salary.min");
		else if(empl.getJob().isEmpty())
			//for checking Job field is not empty
			errors.rejectValue("job", "emp.jobprofile.required");
		else if(!empl.getJob().equals(empl.getJob().toUpperCase()))
			//to check given Job profile is upper case or not
			errors.rejectValue("job", "emp.jobprofile.uppercase-required");
		
		

	}

}//
