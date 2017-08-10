package com.alacriti.empleavetool.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.empleavetool.vo.EmpVo;
import com.alacriti.empleavetool.vo.LeaveVo;

public class HelperClass extends BaseDao {

	public EmpVo empInfoResult(LeaveVo leavevo) {

		String empId = leavevo.getEmpId();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		EmpVo empvo = null;
		Connection conn = null;
		try {

			conn = getConnection();
			System.out.println(empId);
			String query = "SELECT * FROM amans_empleaveportal_emp_info_2_tbl info join amans_empleaveportal_emp_profile_2_tbl profile on profile.emp_id='"
					+ empId + "' AND info.emp_id ='" + empId + "'";
			preparedStatement = conn.prepareStatement(query);
			System.out.println("IDDD :" + empId);
			rs = preparedStatement.executeQuery();
			System.out.println("Executed Query");
			empvo = wrapperEmp(rs);

		} catch (Exception e) {

			System.out.println("ResultSet Info " + e);
			e.printStackTrace();

		}

		return empvo;
	}

	public EmpVo wrapperEmp(ResultSet empInfoResult) throws SQLException {
		EmpVo empvo = new EmpVo();

		if (empInfoResult.next()) {

			empvo.setEmpId(empInfoResult.getString(1));
			empvo.setfName(empInfoResult.getString(2));
			empvo.setmName(empInfoResult.getString(3));
			empvo.setlName(empInfoResult.getString(4));
			empvo.setGender(empInfoResult.getString(5));
			empvo.setContactNo(empInfoResult.getString(6));
			empvo.setLeaveBalance(empInfoResult.getInt(7));
			empvo.setEmail(empInfoResult.getString(9));
			empvo.setEmpStatus(empInfoResult.getBoolean(11));
			empvo.setQuestionId((empInfoResult.getString(13)));
			empvo.setAnswer((empInfoResult.getString(14)));

		}

		return empvo;

	}

	public LeaveVo leaveInfoResult(LeaveVo leavevo) {
		ResultSet rs = null;

		String leaveId = leavevo.getLeaveId();
		LeaveVo leavevo1 = new LeaveVo();
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		try {
			conn = getConnection();
			String query = "Select * from amans_empleaveportal_leave_tbl where leave_id=?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, leaveId);
			System.out.println("In Result " + leavevo1.getLeaveId());
			rs = preparedStatement.executeQuery();

			leavevo1 = wrapperLeave(rs);

		} catch (Exception e) {
			System.out.println("ResultSet Leave Info " + e);

		}
		return leavevo1;
	}

	public LeaveVo wrapperLeave(ResultSet leaveInfoResult) throws SQLException {
		LeaveVo leavevo = new LeaveVo();

		if (leaveInfoResult.next()) {
			leavevo.setLeaveId(leaveInfoResult.getString(1));
			leavevo.setEmpId(leaveInfoResult.getString(2));
			leavevo.setFromDate((leaveInfoResult.getDate(3)));
			leavevo.setReason(leaveInfoResult.getString(5));
			leavevo.setNoDays(leaveInfoResult.getInt(6));
			leavevo.setLeaveTag(leaveInfoResult.getString(7));
			leavevo.setLeaveStatus(leaveInfoResult.getString(8));
			leavevo.setToDate(leaveInfoResult.getDate(9));
		}

		return leavevo;

	}

}