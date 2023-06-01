//Employee Controller class 
package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDto;
import com.nt.service.IEmployeeService;
import com.nt.vo.EmployeeVo;

@Controller("employeeController")
public class EmployeeController {
@Autowired
	private IEmployeeService service;
	
	public List<EmployeeVo> process(String[] dsgs) throws Exception{
		//user service
		List<EmployeeDto> listdto = service.fatchEmployeesByDesg(dsgs);
		//convert listDto to listVO
		List<EmployeeVo> listVo = new ArrayList();
		listdto.forEach(dto->{
			EmployeeVo vo = new EmployeeVo();
			BeanUtils.copyProperties(dto,vo);
			vo.setSlNumber(String.valueOf(dto.getSlNumber()));
			vo.setSal(String.valueOf(dto.getSal()));
			vo.setJob(String.valueOf(dto.getJob()));
			vo.setEname(String.valueOf(dto.getEname()));
			vo.setEmpNo(String.valueOf(dto.getEmpNo()));
			listVo.add(vo);
		});
		return listVo;
	}//method
}//class
