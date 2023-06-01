package com.nt.controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeService;
import com.nt.vo.EmployeeVO;

public class EmployeeMainController {
    
    public IEmployeeService service;

    public EmployeeMainController(IEmployeeService service){
	System.out.println("IEmployeeService :: 1- Param constructor");
	this.service = service;
    }//1-param constructor
    
    public String processSalary(EmployeeVO vo)throws Exception{
	//convert VO class object to DTO class object
	EmployeeDTO dto = new EmployeeDTO();
	dto.setEmpname(vo.getEmpname());
	dto.setEmpaddrs(vo.getEmpaddrs());
	dto.setBasicsalary(Float.parseFloat(vo.getBasicsalary()));
	System.out.println(dto.getBasicsalary());
	String result = service.calculateSalary(dto);
	return result;
    }
    

}
