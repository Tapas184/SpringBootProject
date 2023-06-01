package com.nt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBo;
@Repository("employeeDao")
public class EmployeeDaoImpl implements IEmployeeDao {
	private static final String SELECT_QUERY = "SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE JOB IN";
	@Autowired
	private DataSource ds;
	@Override
	public List<EmployeeBo> getEmployeeByDesg(String cond) throws Exception {
		List<EmployeeBo> listBo = null;
		try (Connection con = ds.getConnection(); // create connection pool with
													// datasource
				// create statement
				Statement st = con.createStatement();
				// create result set and set to EmployeeBo
				ResultSet rs = st
						.executeQuery(SELECT_QUERY + cond + " ORDER BY JOB");) {
			System.out.println(SELECT_QUERY + cond + " ORDER BY JOB");
			listBo = new ArrayList();
			if (rs != null) {
				EmployeeBo bo = null;
				while (rs.next()) {
					// create EmployeeBo class object
					bo = new EmployeeBo();
					bo.setEmpNo(rs.getInt(1));
					bo.setEname(rs.getString(2));
					bo.setSal(rs.getDouble(3));
					bo.setJob(rs.getString(4));
					listBo.add(bo);
				} // while
			}
		} // try
		catch (SQLException se) {
			// exception for known exception
			se.printStackTrace();
			throw se;
		} // catch
		catch (Exception e) {
			// for unknown exception
			e.printStackTrace();
			throw e;
		}
		return listBo;
	}// mthod

}// class
