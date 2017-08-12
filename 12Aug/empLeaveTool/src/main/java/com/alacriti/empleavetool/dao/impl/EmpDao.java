package com.alacriti.empleavetool.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.empleavetool.constants.Constants;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;

public class EmpDao extends BaseDao {
	private PreparedStatement preparedStatement;

	public boolean checkEmpMaster(EmpVo empdetails) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = getConnection();
			String passQuery = "select emp_id from amans_empleaveportal_emp_master_tbl where emp_id=?";
			preparedStatement = conn.prepareStatement(passQuery);
			preparedStatement.setString(1, empdetails.getEmpId());
			ResultSet rs1 = preparedStatement.executeQuery();
			if (rs1.next())
				result = rs1.getString(1) != null;

		} catch (Exception e) {
			System.out.println("In empMaster " + e);
		}
		return result;
	}

	public boolean createNewEmp(EmpVo empdetails) throws DAOException {
		boolean flag = false;
		boolean empProfileResult = false;
		boolean empInfoResult = false;
		Connection conn = null;
		if (checkEmpMaster(empdetails)) {

			try {
				conn = getConnection();

				empInfoResult = createEmpInfo(empdetails, conn);
				empProfileResult = createEmpProfile(empdetails, conn);

				if (empProfileResult && empInfoResult) {
					commitConnection(conn);
					flag = true;
				} else {
					rollbackTransaction(conn);
					System.out.println("Something is not right Rolling Back");
				}

			} catch (Exception e) {
				System.out.println("Exception in createNewEmp()"
						+ e.getMessage());
				throw new DAOException("Exception occur in createNewEmp :" + e);
			}

			finally {
				closeConnection(conn);

			}
			return flag;
		}
		System.out.println("Returning Flag");
		return flag;
	}

	public EmpVo empvalidate(EmpAuthVo empauthvo) throws DAOException {
		Connection conn = null;
		String result = null;
		String empId=null;
		String email = empauthvo.getEmail();
		String password = empauthvo.getPassWord();
		EmpVo empvo= new EmpVo();
		HelperClass leavedaonew = new HelperClass();

		try {
			conn = getConnection();
			System.out.println("In DAo " + empauthvo.getEmail());
		} catch (SQLException e) {
			System.out.println("Exception Occur in creating connection" + e);
		}

		try {
			System.out.println("In empvalidate()");
			String passQuery = "select password,emp_id from amans_empleaveportal_emp_profile_2_tbl where email=?";
			preparedStatement = conn.prepareStatement(passQuery);
			preparedStatement.setString(1, email);
			ResultSet rs1 = preparedStatement.executeQuery();
			if (rs1.next()){
				result = rs1.getString(1);
				empId=rs1.getString(2);
			}
			System.out.println("After Execution " + empId);
		}catch (SQLException e) {
			System.out
					.println("Exception occur in preparing statement for validation"
							+ e);
			throw new DAOException("SQL Exception occur" + e);
		}
		empvo = leavedaonew.empInfoResult(empId);

		if (result.equals(password))
			return empvo;
		return null;

	}

	boolean createEmpInfo(EmpVo empdetails, Connection conn)
			throws DAOException {
		boolean flag = false;
		int resultvalue = 0;
		String query = "Insert into amans_empleaveportal_emp_info_2_tbl values(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = conn.prepareStatement(query);

			preparedStatement.setString(1, empdetails.getEmpId());
			preparedStatement.setString(2, empdetails.getfName());
			preparedStatement.setString(3, empdetails.getmName());
			preparedStatement.setString(4, empdetails.getlName());
			preparedStatement.setString(5, empdetails.getGender());
			preparedStatement.setString(6, empdetails.getContactNo());
			preparedStatement.setInt(7, Constants.TOTAL_LEAVES);

			resultvalue = preparedStatement.executeUpdate();

			if (resultvalue == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println("Exception in createEmployee() "
					+ e.getMessage());
			throw new DAOException("SQLException in createEmpInfo:", e);
		}
		return flag;
	}

	boolean createEmpProfile(EmpVo empdetails, Connection conn)
			throws DAOException {
		boolean flag = false;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("Insert into amans_empleaveportal_emp_profile_2_tbl values(?,?,?,?,null,?,?)");
			preparedStatement.setString(1, empdetails.getEmpId());
			preparedStatement.setString(2, empdetails.getEmail());
			preparedStatement.setString(3, empdetails.getPassWord());
			preparedStatement.setBoolean(4, true);
			preparedStatement.setString(5, empdetails.getQuestionId());
			preparedStatement.setString(6, empdetails.getAnswer());

			int resultvalue = preparedStatement.executeUpdate();

			if (resultvalue == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println("Exception in createEmpProfile()"
					+ e.getMessage());
			throw new DAOException("SQLException in CreateEmpProfile", e);
		}
		return flag;

	}

}
////
//public boolean empvalidate(EmpAuthVo empauthvo) throws DAOException {
//	Connection conn = null;
//	String result = null;
//	String email = empauthvo.getEmail();
//	String password = empauthvo.getPassWord();
//
//	try {
//		conn = getConnection();
//	} catch (SQLException e) {
//		System.out.println("Exception Occur in creating connection" + e);
//	}
//
//	try {
//		System.out.println("In empvalidate()");
//		String passQuery = "select password from amans_empleaveportal_emp_profile_2_tbl where email=?";
//		preparedStatement = conn.prepareStatement(passQuery);
//		preparedStatement.setString(1, email);
//		ResultSet rs1 = preparedStatement.executeQuery();
//		if (rs1.next())
//			result = rs1.getString(1);
//	} catch (SQLException e) {
//		System.out
//				.println("Exception occur in preparing statement for validation"
//						+ e);
//		throw new DAOException("SQL Exception occur" + e);
//	}
//
//	if (result.equals(password))
//		return true;
//	else
//		return false;
//
//}
