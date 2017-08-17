package com.alacriti.empleavetool.deligate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.alacriti.empleavetool.bo.impl.BOException;
import com.alacriti.empleavetool.bo.impl.LeaveBoiImpl;
import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.dao.impl.EmpDao;
import com.alacriti.empleavetool.exception.BaseException;
import com.alacriti.empleavetool.vo.EmpVo;
import com.alacriti.empleavetool.vo.LeaveVo;

public class LeaveDeligate {

	public String applyLeaveDeligate(LeaveVo leavevo) throws DAOException,
			SQLException {
		String LOP = null;
		Date todayDate = new Date();
		EmpDao empdao = new EmpDao();
		Date beforeDate = leavevo.getFromDate();
		Date afterdate = leavevo.getToDate();
		String empId = leavevo.getEmpId();
		LeaveBoiImpl leaveboimpl = new LeaveBoiImpl();
		EmpVo Result = empdao.empInfoResult(empId);
		int leavebalance = Result.getLeaveBalance();
		if (leavebalance <= 0)
			LOP = "LOP Applied";

		if ((beforeDate.before(todayDate))) {
			System.out.println("Please Enter A Valid from date");
			return "Please Enter A Valid from date";
		} else if (afterdate.before(todayDate)) {
			return "Please Enter A Valid  tilll date";
		} else {
			return leaveboimpl.applyNewLeaveBo(leavevo) + LOP;
		}
	}

	public ArrayList<LeaveVo> leaveHistoryDeligate(String leaveVo)
			throws DAOException {

		LeaveBoiImpl leaveboimpl = new LeaveBoiImpl();
		return leaveboimpl.leaveHistoryBo(leaveVo);

	}

	public String leaveApproveDeligate(LeaveVo leavevo) throws DAOException,
			BOException, SQLException {

		LeaveBoiImpl leaveboimpl = new LeaveBoiImpl();
		return leaveboimpl.leaveApproveBo(leavevo);

	}

	public String leaveCancel(LeaveVo leavevo) throws BaseException, Exception {
		String response = null;
		Date todayDate = new Date();

		Date beforeDate = leavevo.getFromDate();
		LeaveBoiImpl leaveboimpl = new LeaveBoiImpl();

		if (todayDate.equals(beforeDate))
			response = "Sorry You Can't Cancel Now";
		else
			try {
				response = leaveboimpl.cancelLeaveBo(leavevo);
			} catch (BOException e) {
				System.out.println("In cancel Deligate" + e);
				e.printStackTrace();
				throw new BaseException();
			}

		return response;

	}

}
