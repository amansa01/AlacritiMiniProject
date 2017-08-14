package com.alacriti.empleavetool.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.empleavetool.constants.Constants;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;

public class EmpDao extends BaseDao {
	private PreparedStatement preparedStatement;

	public boolean checkEmpMaster(EmpVo empdetails) throws SQLException {
		Connection conn = null;
		boolean result = false;
		try {
			conn = getConnection();
			String passQuery = "select emp_id from amans_empleaveportal_emp_master_tbl where emp_id=?";
			preparedStatement = conn.prepareStatement(passQuery);
			preparedStatement.setString(1, empdetails.getEmpId());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next())
				result = rs.getString(1) != null;
			rs.close();

		} catch (Exception e) {
			System.out.println("In empMaster " + e);
		} finally {
			preparedStatement.close();
			closeConnection(conn);

		}
		return result;
	}

	public boolean createNewEmp(EmpVo empdetails) throws DAOException,
			SQLException {
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

		return flag;
	}

	public EmpVo empvalidate(EmpAuthVo empauthvo) throws DAOException,
			SQLException {
		Connection conn = null;
		ResultSet rs =null;
		String result = null;
		String empId = null;
		String email = empauthvo.getEmail();
		String password = empauthvo.getPassWord();
		EmpVo empvo = new EmpVo();
		HelperUtility leavedaonew = new HelperUtility();
		try {
			conn = getConnection();
			
			String passQuery = "select emp_id from amans_empleaveportal_emp_profile_2_tbl where email=? and password=?";
			preparedStatement = conn.prepareStatement(passQuery);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			 rs = preparedStatement.executeQuery();
			if (rs.next()) {
				empId = rs.getString(1);
			}
						System.out.println("vvvv" + empId);
			if (empId != null) {
				
				empvo = empInfoResult(empId);
				return empvo;
			}
			rs.close();
		} catch (SQLException e) {
			System.out
					.println("Exception occur in preparing statement for validation"
							+ e);
			throw new DAOException("SQL Exception occur" + e);
		} finally {
			closeConnection(conn);
			preparedStatement.close();
		}

		
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
			preparedStatement.close();
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
			preparedStatement.close();
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

	public EmpVo empInfoResult(String empId) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		EmpVo empvo = null;
		Connection conn = null;
		HelperUtility helperutility = new HelperUtility();
		try {
		
			conn = getConnection();
			String query = "SELECT * FROM amans_empleaveportal_emp_info_2_tbl info join amans_empleaveportal_emp_profile_2_tbl profile on profile.emp_id='"
					+ empId + "' AND info.emp_id ='" + empId + "'";
			preparedStatement = conn.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			empvo = helperutility.wrapperEmp(rs);
			
			
		} catch (Exception e) {

			System.out.println("ResultSet Info " + e);
			e.printStackTrace();

		} finally {
			preparedStatement.close();
			closeConnection(conn);
			rs.close();
		}

		return empvo;
	}

}
