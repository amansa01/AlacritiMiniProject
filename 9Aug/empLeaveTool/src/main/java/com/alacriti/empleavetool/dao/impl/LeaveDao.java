package com.alacriti.empleavetool.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.empleavetool.vo.EmpVo;
import com.alacriti.empleavetool.vo.LeaveVo;

public class LeaveDao extends BaseDao {

	public String applyNewLeave(LeaveVo leavevo) throws DAOException,
			SQLException {

		Connection conn = null;
		boolean flag = false;
		boolean updateLeaveTable = false;
		try {
			conn = getConnection();
			updateLeaveTable = updateLeaveTable(leavevo, conn);
		} catch (Exception e) {
			System.out.println("Exception in apply new leave" + e.getMessage());
			System.out.println("Checking exception " + e);
			throw new DAOException("Exception occur in createNewEmp :" + e);
		} finally {
			if (updateLeaveTable) {

				commitConnection(conn);

				flag = true;
			} else {
				rollbackTransaction(conn);
				System.out.println("Something ");
			}
		}
		if (flag)
			return "Sussesfully Updated";
		else
			return "Not Updated";
	}

	public String historyOfLeaves(LeaveVo leavevo) throws DAOException {
		Connection conn = null;
		String query = null;
		String emp_id;
		Date date_applied;
		Date leave_to_date;
		int no_days;
		String leave_reason;
		String leave_tag;
		PreparedStatement preparedStatement = null;
		try {
			conn = getConnection();

			query = "Select emp_id,date_applied,leave_to_date,no_days,leave_reason,leave_tag from amans_empleaveportal_leave_tbl where emp_id=?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, leavevo.getEmpId());
			ResultSet rs1 = preparedStatement.executeQuery();
			while (rs1.next()) {

				emp_id = rs1.getString("emp_id");
				date_applied = rs1.getDate("date_applied");
				leave_to_date = rs1.getDate("leave_to_date");
				no_days = rs1.getInt("no_days");
				leave_reason = rs1.getString("leave_tag");
				leave_tag = rs1.getString("leave_tag");

				System.out.println("emp_id : " + emp_id);
				System.out.println("Date Applied : " + date_applied);
				System.out.println(" Leave till Date: " + leave_to_date);
				System.out.println("Days: " + no_days);
				System.out.println("Reason : " + leave_reason);
				System.out.println("Tag : " + leave_tag);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception in historyOfLeavesDao() : " + e);
			throw new DAOException();
		}

		return null;

	}

	boolean updateLeaveTable(LeaveVo leavevo, Connection conn)
			throws DAOException {
		PreparedStatement preparedStatement = null;

		boolean flag = false;
		int resultvalue = 0;
		try {

			String query = "Insert into amans_empleaveportal_leave_tbl(emp_id,date_applied,last_modify_time,leave_reason,no_days,leave_tag,leave_status,leave_to_date) values(?,?,?,?,?,?,?,?)";
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, leavevo.getEmpId());
			preparedStatement.setDate(2, leavevo.getFromDate());
			preparedStatement.setDate(3, date);
			preparedStatement.setString(4, leavevo.getReason());
			preparedStatement.setInt(5, leavevo.getNoDays());
			preparedStatement.setString(6, leavevo.getLeaveTag());
			preparedStatement.setString(7, leavevo.getLeaveStatus());
			preparedStatement.setDate(8, leavevo.getToDate());

			resultvalue = preparedStatement.executeUpdate();
			if (resultvalue == 1) {
				flag = true;

			}

		} catch (SQLException e) {
			System.out.println("Exception in updateLeaveTable "
					+ e.getMessage());
			throw new DAOException("SQLException in createEmpInfo:", e);
		}
		return flag;

	}

	public boolean leaveApproveDao(LeaveVo leavevo) throws DAOException {
		System.out.println("In Dao");
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		String query = null;
		int resultInfoTable = 0;
		int resultLeaveTable = 0;
		String empId = leavevo.getEmpId();

		boolean flag = false;
		LeaveDaoNew leavedaonew = new LeaveDaoNew();
		EmpVo empvo = new EmpVo();
		try {
			conn = getConnection();
			empvo = leavedaonew.empInfoResult(leavevo);
			leavevo = leavedaonew.leaveInfoResult(leavevo);
			if (leavevo.getLeaveStatus().equalsIgnoreCase("InProgress"))
				try {

					System.out.println("In Main progress");
					query = "update amans_empleaveportal_emp_info_2_tbl set leave_bal=? where emp_id=?";
					int updateLeave = (empvo.getLeaveBalance() - leavevo
							.getNoDays());
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setInt(1, updateLeave);
					preparedStatement.setString(2, empId);
					resultInfoTable = preparedStatement.executeUpdate();

					query = "update amans_empleaveportal_leave_tbl set leave_status=? where leave_id=?";
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setString(1, "Approved");
					preparedStatement.setString(2, leavevo.getLeaveId());
					resultLeaveTable = preparedStatement.executeUpdate();
					if (resultInfoTable == 1 && resultLeaveTable == 1) {
						System.out.println("Commiting Connection ");
						commitConnection(conn);
						closeConnection(conn);
						flag = true;

					} else {
						System.out
								.println("Some Problem Occured So Rolling back");
						rollbackTransaction(conn);
					}

				} catch (SQLException e) {
					System.out.println("Exception in LeaveStatusTable"
							+ e.getMessage());
					throw new DAOException("SQLException in createEmpInfo:", e);

				}

		} catch (SQLException e) {
			System.out.println("Exception in updateEmpInfoResult"
					+ e.getMessage());
			throw new DAOException("SQLException in createEmpInfo:", e);

		}

		return flag;
	}

	public boolean cancelLeave(LeaveVo leavevo) throws DAOException {
		PreparedStatement preparedStatement = null;
		String leaveStatus = null;
		Connection conn = null;
		String query = null;
		int result = 0;
		int result1 = 0;
		boolean flag = false;
		int leaveBalance = 0;
		LeaveDaoNew leavedaonew = new LeaveDaoNew();
		EmpVo empvo = new EmpVo();
		try {
			empvo = leavedaonew.empInfoResult(leavevo);
			leavevo = leavedaonew.leaveInfoResult(leavevo);
			System.out.println("In Dao");
			conn = getConnection();

			System.out.println("Leave Status " + leavevo.getLeaveStatus());
			if (leavevo.getLeaveStatus().equalsIgnoreCase("Approved")) {
				query = "update amans_empleaveportal_leave_tbl set leave_status=? where leave_id=?";
				preparedStatement = conn.prepareStatement(query);
				preparedStatement.setString(1, "Cancel");
				preparedStatement.setString(2, leavevo.getLeaveId());
				result1 = preparedStatement.executeUpdate();

				leaveBalance = empvo.getLeaveBalance();
				System.out.println("Before Updating leave Balance "
						+ leaveBalance);

				query = "update amans_empleaveportal_emp_info_2_tbl set leave_bal=? where emp_id=?";
				int updateLeaveBalance = (empvo.getLeaveBalance() + leavevo
						.getNoDays());
				preparedStatement = conn.prepareStatement(query);
				preparedStatement.setInt(1, updateLeaveBalance);
				preparedStatement.setString(2, empvo.getEmpId());
				result = preparedStatement.executeUpdate();

			}

			System.out.println("In cancel leave" + leaveStatus);
			if (result1 == 1 && result == 1) {
				System.out.println("Commiting Connection ");
				commitConnection(conn);
				closeConnection(conn);
				flag = true;

			} else {
				System.out.println("Some Problem Occured Rolling back");
				rollbackTransaction(conn);
			}

		} catch (SQLException e) {
			System.out.println("In Dao cancel " + e);
			e.printStackTrace();
			throw new DAOException();
		}
		return flag;
	}
}
