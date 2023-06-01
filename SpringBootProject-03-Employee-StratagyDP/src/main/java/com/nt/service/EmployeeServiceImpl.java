package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBo;
import com.nt.dao.IEmployeeDao;
import com.nt.dto.EmployeeDto;
@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao dao;
	@Override
	public List<EmployeeDto>  fatchEmployeesByDesg(String[] dsgs) throws Exception {
		String cond = null;
		//convert designation array in condition in cause in SQL Query form('CLERK','MANAGER','SALSEMANE')
		StringBuffer buffer = new StringBuffer("(");
		for(int i=0;i<dsgs.length;++i) {//for loop for itteration all the element present in Array
			if(i==dsgs.length-1)
				buffer.append("'"+dsgs[i]+"')");
				else
					buffer.append("'"+dsgs[i]+"',");
		}
		cond=buffer.toString();
		//use Dao object
		List<EmployeeBo> listbo = dao.getEmployeeByDesg(cond);
		//create a EmployeeDto object
		List<EmployeeDto> listDto= new ArrayList();
		//convert listBo to listDto
		listbo.forEach(bo->{
			EmployeeDto dto = new EmployeeDto();
			//copy each bo class object data to each dto class object data
			BeanUtils.copyProperties(bo, dto); //bo properties and type must match with dto properties
			//set dto slNumber by
			dto.setSlNumber(listDto.size()+1);
			//add each dto class object to listDto class
			listDto.add(dto);
			});
		return listDto;
	}//method

}//class
