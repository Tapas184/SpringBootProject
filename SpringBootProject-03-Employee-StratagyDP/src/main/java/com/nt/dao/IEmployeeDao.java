//Interface for EmployeeDao
package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBo;

public interface IEmployeeDao {
	public  List<EmployeeBo> getEmployeeByDesg(String cond) throws Exception;
}//class
