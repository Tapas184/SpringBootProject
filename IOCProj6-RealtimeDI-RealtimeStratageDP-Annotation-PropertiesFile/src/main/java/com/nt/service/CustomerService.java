package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.bo.CustomerBo;
import com.nt.dao.ICustomerDAO;
import com.nt.dto.CustomerDTO;
@Service("custService")
public final class CustomerService implements ICustomerService {
    @Autowired
    @Qualifier("dt")
    public ICustomerDAO dao; // HAS-Property
    
    public String calculateSimpleIntrest(CustomerDTO dto) throws Exception {
    
       float intAmount = (dto.getRootAmount()*dto.getRate()*dto.getTime())/100.0f;
       float totalAmount = intAmount+dto.getRootAmount();
       CustomerBo bo = new CustomerBo();
       bo.setCustName(dto.getCustName());
       bo.setCustAdd(dto.getCustAdd());
       bo.setRootAmount(dto.getRootAmount());
       bo.setRate(dto.getRate());
       bo.setTime(dto.getTime());
       bo.setIntrest(intAmount);
       //use DAO
       int count = dao.insert(bo);
       //Terinary operator
       return count==1?"Sucessfully Registered....Intrest Amount is"+intAmount+"Total Pay after "+dto.getTime()+"Month is "+totalAmount:"Customer Registration Failed";
    }

}
