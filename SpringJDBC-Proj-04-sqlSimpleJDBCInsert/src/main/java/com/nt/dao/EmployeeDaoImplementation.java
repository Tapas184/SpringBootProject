package com.nt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;
@Repository("dao")
//make this class as Java Bean
public class EmployeeDaoImplementation implements IDaoEmployeeInterface {
	@Autowired
	private SimpleJdbcInsert sji;

	/*@Override
	public int insertEmployee(Employee emp) {
		//set the DB table name where you want to insert the record
		sji.setTableName("EMP");
		Map<String,Object> map = Map.of("EMPNO",emp.getEmpno(),
				                        "ENAME",emp.getEname(),
				                        "JOB",emp.getJob(),
				                        "SAL",emp.getSal());
		 int count=sji.execute(map);
		return count;
			}*/
	//if model class properties and Table column name same then use this 
	@Override
	public int insertEmployee(Employee emp) {
		//set table name
		sji.setTableName("EMP");
		//use beanpropertysqlparameter source
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(emp);
		//execute the query
		int count=sji.execute(source);
		return count;
	}


}
