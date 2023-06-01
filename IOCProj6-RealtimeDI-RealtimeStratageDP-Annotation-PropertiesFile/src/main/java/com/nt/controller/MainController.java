package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.ICustomerService;
import com.nt.vo.CustomerVO;
@Controller("custContoller")
public class MainController {
    @Autowired
    private ICustomerService service;
    
    public String processCustomer(CustomerVO vo)throws Exception {
	//convert VO class object to DTO class object data
	CustomerDTO dto = new CustomerDTO();
	dto.setCustName(vo.getCustName());
	dto.setCustAdd(vo.getCustAdd());
	dto.setRate(Float.parseFloat(vo.getRate()));
	dto.setRootAmount(Integer.parseInt(vo.getRootAmount()));
	dto.setTime(Integer.parseInt(vo.getTime()));
	String result = service.calculateSimpleIntrest(dto);
	return result;
    }

}
