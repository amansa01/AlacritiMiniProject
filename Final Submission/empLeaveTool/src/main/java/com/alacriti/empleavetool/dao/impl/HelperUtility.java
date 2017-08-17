package com.alacriti.empleavetool.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.empleavetool.vo.EmpVo;
import com.alacriti.empleavetool.vo.LeaveVo;

public class HelperUtility extends BaseDao {

	

	public EmpVo wrapperEmp(ResultSet empInfoResult) throws SQLException {
		EmpVo empvo = new EmpVo();
		if(empInfoResult==null)
			return null;
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

	

	public LeaveVo wrapperLeave(ResultSet leaveInfoResult) throws SQLException {
		LeaveVo leavevo = new LeaveVo();
		if(leaveInfoResult==null)
			return null;
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