package com.alacriti.aman.dao.impl;

import java.sql.Connection;

import com.alacriti.aman.constants.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.aman.vo.EmpAuthVo;
import com.alacriti.aman.vo.EmpVo;
import com.alacriri.aman.dao.*;

public class EmpDao {
	private PreparedStatement preparedStatement;
	static boolean flag;
	BaseDao basedao = new BaseDao();

	public boolean createNewEmp(EmpVo empdetails) throws SQLException {
		try {
//			create connection
			basedao.createEmpProfile(empdetails);
			
			basedao.createEmpInfo(empdetails);
			flag= true;
			
			//commit
		} catch (Exception e) {
			System.out.println(e);
			
		}

		finally {
			basedao.closeConnection();

		}
		return flag;
	}

	public boolean empvalidate(EmpAuthVo empauthvo) throws SQLException {
		Connection conn = basedao.createConnection();
		String empId = empauthvo.getEmpId();
		String email = empauthvo.getEmail();
		String password = empauthvo.getPassWord();

		String passQuery = "select password from amans_empleaveportal_emp_profile_tbl where email=? and emp_id=?";

		preparedStatement = conn.prepareStatement(passQuery);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, empId);

		String result = null;
		ResultSet rs1 = preparedStatement.executeQuery();
		if (rs1.next())
			result = rs1.getString(1);

		if (result.equals(password))
			return true;
		else
			return false;

	}
}
