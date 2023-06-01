package com.nt.Spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.Spring.bo.PaitentBO;

public final class PaitentDao implements IpaitentDao {
	private static final String QUERY="INSERT INTO PAITENT_REG VALUES(SE1.NEXTVAL,?,?,?,?,?,?)";
	DataSource ds;
    public PaitentDao(DataSource ds) {
	System.out.println("DataSource:: 1- param construction");
	    this.ds = ds;
	}//one param construction



    public int insert(PaitentBO bo) throws Exception {
	int count=0;
	try(Connection con=ds.getConnection();
		PreparedStatement ps = con.prepareStatement(QUERY)) {
	    if(ps!=null)
		ps.setString(1, bo.getPatientname());
	    ps.setString(2, bo.getPaitentaddress());
	    ps.setLong(3, bo.getPaitentnumber());
	    ps.setInt(4, bo.getPaitentncount());
	    ps.setFloat(5, bo.getTotalbillamount());
	    ps.setFloat(6, bo.getNetbillamount());
	    //execute prepared statement
	    count = ps.executeUpdate();
	}
	catch(SQLException se) {
	  throw se ;
	}
	catch(Exception e) {
	    throw e;
	}
	return count;
    }

}
