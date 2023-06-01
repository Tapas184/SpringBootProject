package com.nt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;
@Repository("dao")
//make this class as Java Bean
public class EmployeeDaoImplementation implements IDaoEmployeeInterface {
//sql Query for getEmployeeName By ID
	private  static final String QUERY_FOR_EMPNAME="SELECT ENAME FROM EMP WHERE EMPNO=:no";
	private static final String QUERY_FOR_LISTOFEMP_BYJOB="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(:job1,:job2) ORDER BY JOB";
	@Autowired //Automatic inject to target class and ready for use
	private NamedParameterJdbcTemplate npjt;
	@Override
	public String getEmployeeNameById(Integer id) {
		Map<String,Object> map = Map.of("no",id);
	String name=	npjt.queryForObject(QUERY_FOR_EMPNAME, map,String.class);
	if(name!=null)
		return name;
	else
		return"Employee Not found";
	}
	@Override
	public List<Employee> getEmployeeListByJob(String deg1, String deg2) {
		//when Model properties and name paramete not matched take MapSQLParameterSource
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("job1", deg1);
		source.addValue("job2", deg2);
		
		List<Employee> emplist=npjt.query(QUERY_FOR_LISTOFEMP_BYJOB, 
				                        source,
				                        rs->{
				                        	List<Employee> list = new ArrayList();
				                        	while(rs.next()) {
				                        		Employee e = new Employee();
				                        		e.setEmpno(rs.getInt(1));
				                        		e.setEname(rs.getString(2));
				                        		e.setJob(rs.getString(3));
				                        		e.setSal(rs.getDouble(4));
				                        		list.add(e);
				                        	}//while
				                        	return list;
				                        });
		return emplist;
	}

}
