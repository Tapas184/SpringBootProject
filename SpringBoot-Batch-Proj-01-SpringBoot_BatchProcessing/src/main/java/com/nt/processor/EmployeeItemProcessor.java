package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.model.Employee;
 
@Component
public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee emp) throws Exception {
		if(emp.getSal()>=60000) {
			emp.setGrossSal(Math.round(emp.getSal()+emp.getSal()*0.4f));
			emp.setNetSal(Math.round(emp.getGrossSal()-emp.getGrossSal()*0.2f));
			return emp;
		}
		return null;
	}

}
