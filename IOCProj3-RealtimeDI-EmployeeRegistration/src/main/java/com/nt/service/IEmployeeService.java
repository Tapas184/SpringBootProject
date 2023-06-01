package com.nt.service;

import com.nt.dto.EmployeeDTO;
//create interface using DTO class object
public interface IEmployeeService {
    public String calculateSalary(EmployeeDTO dto) throws Exception;

}
