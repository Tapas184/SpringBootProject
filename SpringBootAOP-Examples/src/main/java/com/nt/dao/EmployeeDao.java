package com.nt.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nt.annotaion.CustomTxn;

@Component
public class EmployeeDao {

private static final Logger log = LoggerFactory.getLogger(EmployeeDao.class);

	@CustomTxn
	public void saveEmployee() {
		log.info("Save Employee Data");
	}
}//End of class EmployeeDao
