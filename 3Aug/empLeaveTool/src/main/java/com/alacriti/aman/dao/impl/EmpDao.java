package com.alacriti.aman.dao.impl;

import java.sql.Connection;

import com.alacriti.aman.constants.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.aman.deligate.*;


public class EmpDao {

	public static PreparedStatement preparedStatement;
	static Connection con;
	static boolean flag;

	public String addEmployee(){
		System.out.println("In dao");
		return "employee added";
	}
	
	
	public static boolean createNewEmp(com.alacriti.aman.vo.EmpVo empdetails)
			throws SQLException {
		try {
			//con = BaseDao.createConnection();
			PreparedStatement ps = con
					.prepareStatement("Insert into amans_empleaveportal_emp_info_tbl values(?,?,?,?,?,?)");

		preparedStatement.setString(1, empdetails.getEmpId());
			preparedStatement.setString(2, empdetails.getFname());
			preparedStatement.setString(3, empdetails.getLname());
			preparedStatement.setString(4, empdetails.getGender());
			preparedStatement.setString(5, empdetails.getContactNo());
			preparedStatement.setInt(6, Constants.TOTAL_LEAVES);

			preparedStatement.executeUpdate();
		flag=true;
		} catch (Exception e) {
			System.out.println(e);
		} 
		
		
		try {
			con = BaseDao.createConnection();
			PreparedStatement ps = con
					.prepareStatement("Insert into amans_empleaveportal_emp_profile_tbl values(?,?,?,?,?,?)");

			/*preparedStatement.setString(1, empdetails.empId);
			preparedStatement.setString(2, empdetails.email);
			preparedStatement.setString(3, empdetails.passWord);
			preparedStatement.setboolean(4, empdetails.empStatus);
			preparedStatement.setString(5, empdetails.questionId);
			preparedStatement.setString(6, empdetails.answer);*/

			preparedStatement.executeUpdate();
		flag=true;
		} catch (Exception e) {
			System.out.println(e);
		} 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
}
