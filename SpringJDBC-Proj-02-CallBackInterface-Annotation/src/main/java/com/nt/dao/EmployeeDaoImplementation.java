package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("repo") // make the class as java bean
public class EmployeeDaoImplementation implements IDaoEmployeeInterface {

	// prepared Query
	private final static String GET_EMP_BYID = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	// Query for get Employee by job
	private final static String GET_EMPLIST_BYJOB = "SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE JOB IN(?,?) ORDER BY JOB";
	// inject DS
	@Autowired // inject the data source automatically and keep connection ready for us
	private JdbcTemplate jt;

	@Override
	public Employee getEmployeeByID(Integer id) {
		/*	Employee emp=	jt.queryForObject(GET_EMP_BYID, new RowMapper<Employee>() {
		
					@Override
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee e = new Employee();
						e.setEmpno(rs.getInt(1));
						e.setEname(rs.getString(2));
						e.setJob(rs.getString(3));
						e.setSal(rs.getDouble(4));
						return e;
					     }
					},
						id);
				return emp;*/
		Employee emp = jt.queryForObject(GET_EMP_BYID, (rs, row) -> {
			Employee e = new Employee();
			e.setEmpno(rs.getInt(1));
			e.setEname(rs.getString(2));
			e.setJob(rs.getString(3));
			e.setSal(rs.getDouble(4));
			return e;
		}, id);
		return emp;

	}// method

	@Override
	public List<Employee> getEmployeeByJob(String job1, String job2) {
		List<Employee> listEmp = jt.query(GET_EMPLIST_BYJOB, rs -> {
			//create a List collection with Employee type
			List<Employee> empList = new ArrayList();
			while (rs.next()) {
				//create a Employee class object
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setSal(rs.getDouble(3));
				emp.setJob(rs.getString(4));
				
				empList.add(emp);
			} // while
			//return empList
			return empList;
		},

				job1, job2);

		return listEmp;
	}
}
