package com.alacriti.aman.dao.impl;

import java.sql.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


public class BaseDao {
	// public static void main(String args[])throws Exception {

	private static Connection conn;

	
	public static Connection createConnection() throws SQLException {
		DataSource ds = null;
	
	//	String Query = "select emp_id from amans_empleaveportal_emp_master_tbl where emp_id='AL500'";
		try {
			ds = (DataSource) new InitialContext()
					.lookup("java:jboss/datasources/TRAINEEE");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = ds.getConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

}
