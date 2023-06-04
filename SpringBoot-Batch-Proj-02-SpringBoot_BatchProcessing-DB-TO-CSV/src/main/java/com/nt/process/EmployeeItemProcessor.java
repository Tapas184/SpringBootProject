package com.nt.process;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.model.Employee;

@Component
public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {
	@Override
	public Employee process(Employee item) throws Exception {
		if(item.getNetSal()>150000) {
			return item;
		}
		return null;
	}

}
