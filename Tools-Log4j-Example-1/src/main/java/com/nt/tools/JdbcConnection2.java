package com.nt.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;

public class JdbcConnection2 {
	// create logger obj
	private static Logger logger = Logger.getLogger(JdbcConnection2.class); // this is the singleton calss

	static { //configure log4j properties files
		PropertyConfigurator.configure("src/main/java/com/nt/commons/log4j.properties");
		logger.debug("com.nt.tools.Conenction.class ::-logger started");
	}// static
	
	private static final String SELECT_QUERY = "SELECT EMPNO,ENAME,SAL,JOB FROM EMP";

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","c##tapasrout","routtapas1");
			logger.debug("com.nt.tools.Conenction.class ::-oracle driver loaded ");
			if(con!=null)
				ps=con.prepareStatement(SELECT_QUERY);
			logger.debug("com.nt.tools.Conenction.class ::-connection established");
			if(ps!=null)
				rs=ps.executeQuery();
			logger.debug("com.nt.tools.Conenction.class ::- PreparedStatement prepared");
			logger.warn("com.nt.tools.Conenction.class ::- Used getString method forther use strong method");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}//while
			logger.debug("om.nt.tools.Conenction.class ::- result set prepared");
			
		}//try
		catch(Exception e) {
			e.printStackTrace();
			logger.fatal("om.nt.tools.Conenction.class ::- Unknown error rised "+e.getMessage());
		}//catch
		finally {
			if(rs!=null) {
				try {
					rs.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
					logger.error("om.nt.tools.Conenction.class ::- Known error rised"+se.getErrorCode()+" "+se.getMessage());
				}
				catch(Exception e) {
					e.printStackTrace();
					logger.fatal("om.nt.tools.Conenction.class ::- Unknown error rised "+e.getMessage());
				}
			}
				if(ps!=null) {
					try {
						ps.close();
					}
					catch(SQLException se) {
						se.printStackTrace();
						logger.error("om.nt.tools.Conenction.class ::- Known error rised"+se.getErrorCode()+" "+se.getMessage());
					}
					catch(Exception e) {
						e.printStackTrace();
						logger.fatal("om.nt.tools.Conenction.class ::- Unknown error rised "+e.getMessage());
					}
			}
				if(con!=null) {
					try {
						con.close();
					}
					catch(SQLException se) {
						se.printStackTrace();
						logger.error("om.nt.tools.Conenction.class ::- Known error rised"+se.getErrorCode()+" "+se.getMessage());
					}
					catch(Exception e) {
						e.printStackTrace();
						logger.fatal("om.nt.tools.Conenction.class ::- Unknown error rised "+e.getMessage());
					}//catch
				}//if
		}//
	}// main
}// class
