package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.CustomerBo;

public class CustomerDAOImpl implements ICustomerDAO {
	private static final String INSERT_QUERY = "INSERT INTO CUSTOMER_INTREST VALUES(SE1.NEXTVAL,?,?,?,?,?,?)";
    private DataSource ds;
    PreparedStatement ps=null;
    // Constructor for Data source for every request a new DataSource object needs to be create
    //Constructor Inject of Data Source
    public CustomerDAOImpl(DataSource ds) {
	super();
	this.ds = ds;
    }

    public int insert(CustomerBo bo) throws Exception {
	Connection con=null;
	int count=0;
	try {
	   con = ds.getConnection();
	   ps = con.prepareStatement(INSERT_QUERY);
	   ps.setString(1, bo.getCustName());
	   ps.setString(2, bo.getCustAdd());
	   ps.setInt(3, bo.getRootAmount());
	   ps.setFloat(4, bo.getRate());
	   ps.setInt(5, bo.getTime());
	   ps.setFloat(6, bo.getIntrest());
	   //execute the query
	   count=ps.executeUpdate();  
	}//catch
	catch(SQLException se) {
	    se.printStackTrace();
	    throw se;
	}//catch
	catch(Exception e) {
	    e.printStackTrace();
	    throw e;
	}//catch
	finally { // clean of code, closing the opened connection
	    try {
	    if(con!=null)
		con.close();
	    }catch(SQLException se) {
		se.printStackTrace();
	    }
	    catch(Exception e) {
		e.printStackTrace();
	    }
	    try {
	    if(ps!=null)
		ps.close();
	    }catch(SQLException se) {
		se.printStackTrace();
	    }
	    catch(Exception e) {
		e.printStackTrace();
	    }
	}//finally
	return count;
    }

}
