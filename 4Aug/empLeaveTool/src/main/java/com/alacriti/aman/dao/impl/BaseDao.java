package com.alacriti.aman.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.alacriti.aman.constants.Constants;
import com.alacriti.aman.vo.EmpVo;

public class BaseDao {

	private Connection conn;
	private PreparedStatement preparedStatement;

	public Connection createConnection() throws SQLException {
		DataSource ds = null;

		// String Query =
		// "select emp_id from amans_empleaveportal_emp_master_tbl where emp_id='AL500'";
		try {
			ds = (DataSource) new InitialContext()
					.lookup("java:jboss/datasources/TRAINEEE");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	void closeConnection() {
		if (conn != null) {
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	boolean createEmpInfo(EmpVo empdetails) {

		/* private Connection con; */
		try {

			preparedStatement = conn
					.prepareStatement("Insert into amans_empleaveportal_emp_info_tbl values(?,?,null,?,?,?,?)");
			preparedStatement.setString(1, empdetails.getEmpId());
			preparedStatement.setString(2, empdetails.getfName());
			preparedStatement.setString(3, empdetails.getlName());
			preparedStatement.setString(4, empdetails.getGender());
			preparedStatement.setString(5, empdetails.getContactNo());
			preparedStatement.setInt(6, Constants.TOTAL_LEAVES);

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	boolean createEmpProfile(EmpVo empdetails) {
		try {
			conn = createConnection();
			preparedStatement = conn
					.prepareStatement("Insert into amans_empleaveportal_emp_profile_tbl values(?,?,?,?,null,?,?)");
			preparedStatement.setString(1, empdetails.getEmpId());
			preparedStatement.setString(2, empdetails.getEmail());
			preparedStatement.setString(3, empdetails.getPassWord());
			preparedStatement.setBoolean(4, empdetails.getEmpStatus());
			preparedStatement.setString(5, empdetails.getQuestionId());
			preparedStatement.setString(6, empdetails.getAnswer());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;

	}
}
