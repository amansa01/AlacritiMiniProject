package com.alacriti.empleavetool.bo.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.empleavetool.bo.LeaveIbo;
import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.dao.impl.LeaveDao;
import com.alacriti.empleavetool.vo.LeaveVo;

public class LeaveBoiImpl implements LeaveIbo {

	public String applyNewLeaveBo(LeaveVo leavevo) throws DAOException,
			SQLException {
		LeaveDao leavedao = new LeaveDao();
		try {

		} catch (Exception e) {
			System.out.println("Exception occur in newEmp() " + e);
		}
		return leavedao.applyNewLeave(leavevo);
	}

	public ArrayList<LeaveVo> leaveHistoryBo(LeaveVo leavevo) throws DAOException {
		LeaveDao leavedao = new LeaveDao();
		return leavedao.historyOfLeaves(leavevo);
	}

	public String leaveApproveBo(LeaveVo leavevo) throws BOException {
		System.out.println("In BO");
		// String result=null;
		boolean result = false;
		LeaveDao leavedao = new LeaveDao();
		try {
			result = leavedao.leaveApproveDao(leavevo);
		} catch (DAOException e) {
			System.out.println(e);
			throw new BOException();
		}
		if (result)
			return "Leave Approved";
		else
			return "leave Denied";
	}

	public String cancelLeaveBo(LeaveVo leavevo) throws BOException, Exception {
		String status;
		String ReturnBo;
		boolean reDao = false;
		LeaveDao leavedao = new LeaveDao();
		status = leavevo.getLeaveStatus();
		System.out.println("In Bo leave Status " + status);
//		System.out.println("In BO");
//		System.out.println(status + " 123");

		// if(status.equalsIgnoreCase("Cancel")||status.equalsIgnoreCase("availed"))
		// ReturnBo="Leave Cancelled or Already Avialed";
		// else
		try {
			reDao = leavedao.cancelLeave(leavevo);
		} catch (DAOException e) {
			System.out.println("In Bo cancel " + e);
			e.printStackTrace();
			throw new BOException();
		}
		if (reDao) {
			ReturnBo = "Leave Cancel";
		} else
			ReturnBo = "Leave Not cancel";
		return ReturnBo;
	}

}
