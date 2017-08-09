package com.alacriti.empleavetool.deligate;

import java.sql.SQLException;
import java.util.Date;

import com.alacriti.empleavetool.bo.impl.BOException;
import com.alacriti.empleavetool.bo.impl.LeaveBoiImpl;
import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.exception.BaseException;
import com.alacriti.empleavetool.vo.LeaveVo;

public class LeaveDeligate {

	public String applyLeaveDeligate(LeaveVo leavevo) throws DAOException,
			SQLException {
		Date beforeDate = leavevo.getFromDate();
		Date afterdate = leavevo.getToDate();
		LeaveBoiImpl leaveboimpl = new LeaveBoiImpl();
		// System.out.println(leavevo.getFromDate());
		Date todayDate = new Date();
		if ((beforeDate.before(todayDate))) {
			return "Please Enter A Valid from date";
		} else if (afterdate.before(todayDate)) {
			return "Please Enter A Valid  tilll date";
		} else {
			return leaveboimpl.applyNewLeaveBo(leavevo);
		}
	}

	public String leaveHistoryDeligate(LeaveVo leavevo) throws DAOException {

		LeaveBoiImpl leaveboimpl = new LeaveBoiImpl();
		return leaveboimpl.leaveHistoryBo(leavevo);

	}

	public String leaveApproveDeligate(LeaveVo leavevo) throws DAOException,
			BOException {

		LeaveBoiImpl leaveboimpl = new LeaveBoiImpl();
		System.out.println("In Deligate");
		String Result = null;
		System.out.println("Checking status of leave " + leavevo.getLeaveStatus());
		System.out.println("Checking Id of leave " + leavevo.getLeaveId());
		return leaveboimpl.leaveApproveBo(leavevo);
		// System.out.println(leavevo.getLeaveStatus());
		// try{
		// if (leavevo.getLeaveStatus().equals("InProgress"))
		// { Result=leaveboimpl.leaveApproveBo(leavevo);}
		//
		// else if (leavevo.getLeaveStatus().equals("Availed"))
		// Result= "You Already Availed Leave";
		// else
		// Result= "Technical Problem please try again";
		// }catch (Exception e)
		// {System.out.println(e);
		// }
		// return Result;}
	}

	public String leaveCancel(LeaveVo leavevo) throws BaseException,Exception {
		String Return = null;
		Date todayDate = new Date();
		Date beforeDate = leavevo.getFromDate();
		LeaveBoiImpl leaveboimpl = new LeaveBoiImpl();
		System.out.println("In Deligate");

		
		if (todayDate.equals(beforeDate)) 
			Return = "Sorry You Can't Cancel Now";
		else
			try {
				Return = leaveboimpl.cancelLeaveBo(leavevo);
			} catch (BOException e) {
				System.out.println("In Deligate cancel " + e);
				e.printStackTrace();
				throw new BaseException(); 
			}
		
		return Return;

	}

}
