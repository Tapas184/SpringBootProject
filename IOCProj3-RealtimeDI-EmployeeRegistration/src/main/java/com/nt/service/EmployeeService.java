package com.nt.service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeService implements IEmployeeService {
    
    public IEmployeeDAO dao;
    

    public EmployeeService(IEmployeeDAO dao) {
	System.out.println("IEmployeeDAO :: 1-Param constructor");
	this.dao = dao;
    }


    @Override
    public String calculateSalary(EmployeeDTO dto) throws Exception {
	Float hrAmount = (float) (dto.getBasicsalary()*0.08);
	 Float pfAmount = (float) (dto.getBasicsalary()*0.12);
	    Float grossAmount = dto.getBasicsalary()+hrAmount+pfAmount;
	    Float netAmount = grossAmount-pfAmount;
	    
	    EmployeeBO bo = new EmployeeBO();
	    bo.setBasicsalary(dto.getBasicsalary());
	    bo.setEmpaddrs(dto.getEmpaddrs());
	    bo.setEmpname(dto.getEmpname());
	    bo.setGrosssalary(grossAmount);
	    bo.setNetsalary(netAmount);
	    bo.setHramount(hrAmount);
	    bo.setPfamount(pfAmount);
	    
	    int result =dao.insert(bo);
	return result==1?"Salry Calculate SucessFully...Employee:: "+dto.getEmpname()+" CTC is "+grossAmount+" Take Home is "+netAmount:" SalaryCalculate Failed ";
    }
}
