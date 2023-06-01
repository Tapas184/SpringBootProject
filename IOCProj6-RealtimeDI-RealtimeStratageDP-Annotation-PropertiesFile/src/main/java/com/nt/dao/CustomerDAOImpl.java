package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBo;
@Repository("custOraDao")
public class CustomerDAOImpl implements ICustomerDAO {
	private static final String INSERT_QUERY = "INSERT INTO CUSTOMER_INTREST VALUES(SE1.NEXTVAL,?,?,?,?,?,?)";
	@Autowired
    private DataSource ds;
    PreparedStatement ps=null;

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
		throw se;
	    }
	    catch(Exception e) {
		e.printStackTrace();
		throw e;
	    }
	    try {
	    if(ps!=null)
		ps.close();
	    }catch(SQLException se) {
		se.printStackTrace();
		throw se;
	    }
	    catch(Exception e) {
		e.printStackTrace();
		throw e;
	    }
	}//finally
	return count;
    }

}
