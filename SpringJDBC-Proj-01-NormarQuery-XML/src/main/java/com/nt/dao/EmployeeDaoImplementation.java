package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoImplementation implements IDaoEmployeeInterface {
//Static Query area
	private final static String EMP_COUNT_QUERY="SELECT COUNT(*) FROM EMP";
	private final static String EMP_BYID_QUERY="SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE EMPNO=?";
	private final static String EMP_BYJOB_QUERY="SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE JOB IN(?,?)";
	
	//as this is mandatory to inject so need to go with constructor
	//this template will take to with DB team
	private JdbcTemplate jt;
	
	//take constructor
	public EmployeeDaoImplementation(JdbcTemplate jt) {
		//inject JDBC template dependent class in to target  class
		//dependent clazz= JDBCTemplate
		//target class=EmployeeDaoImplementation
		this.jt=jt;
	}

	@Override
	public int getEmployeeCount() {
		//using jt need to call method
		int count=jt.queryForObject(EMP_COUNT_QUERY, Integer.class); //QueryforObject for single object out put so I call
		//queryfor object parameter(String sql, <which type out put u want That type of Wraper class need to pass>
		return count;
	}

	@Override
	public Map<String, Object> getEmployeById(Integer id) {
		//find employee by it's id
	Map<String, Object> employee=	jt.queryForMap(EMP_BYID_QUERY, id);
	//out put will give in map object where key(String)=column value, Value=row value
		return employee;
	}

	@Override
	public List<Map<String, Object>> getEmployeListByJob(String job1, String job2) {
	List<Map<String, Object>> employee=	jt.queryForList(EMP_BYJOB_QUERY, job1,job2);
		return employee;
	}

}
