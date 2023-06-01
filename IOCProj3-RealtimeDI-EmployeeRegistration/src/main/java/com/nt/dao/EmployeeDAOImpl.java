package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements IEmployeeDAO {
   private static final String QUERRY="INSERT INTO EMP_REGISTRATION VALUES(SE1.NEXTVAL,?,?,?,?,?,?,?)";
   public DataSource ds;
    public EmployeeDAOImpl(DataSource ds) {
	System.out.println("Datasource :: 1-Param constructor");
    this.ds = ds;
}

    @Override
    public int insert(EmployeeBO bo) throws Exception {
	int count =0;
	try(Connection con=ds.getConnection();
		PreparedStatement ps =con.prepareStatement(QUERRY)) {
	    ps.setString(1, bo.getEmpname());
	    ps.setString(2, bo.getEmpaddrs());
	    ps.setFloat(3, bo.getBasicsalary());
	    ps.setFloat(4, bo.getGrosssalary());
	    ps.setFloat(5, bo.getNetsalary());
	    ps.setFloat(6, bo.getHramount());
	    ps.setFloat(7, bo.getPfamount());
	    //execute prepared statement
	    count = ps.executeUpdate();
	}
	catch(SQLException e) {
	    e.printStackTrace();
	    throw e;
	}
	catch(Exception se) {
	    se.printStackTrace();
	    throw se;
	}
	
	return count;
    }

}
