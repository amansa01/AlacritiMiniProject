package com.alacriti.empleaveapp.resteasy.resource;

import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.empleavetool.bo.impl.BOException;
import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.deligate.LeaveDeligate;
import com.alacriti.empleavetool.exception.BaseException;
import com.alacriti.empleavetool.vo.LeaveVo;

@Path("/leave")
public class LeavesResource {

	@POST
	@Path("/history")
	@Produces(MediaType.APPLICATION_JSON)
	public String history(LeaveVo leavevo) throws DAOException {
		LeaveDeligate deligate= new LeaveDeligate();
		return deligate.leaveHistoryDeligate(leavevo);

	}

	@POST
	@Path("/cancel")
	@Produces(MediaType.APPLICATION_JSON)
	public String cancel(LeaveVo leavevo) throws DAOException {
		String result=null;
		System.out.println("In Resource");
		LeaveDeligate deligate= new LeaveDeligate();
		try {
			result= deligate.leaveCancel(leavevo);
		} catch (BaseException e) {
			System.out.println("In resource cancel " + e);
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@POST
	@Path("/newleave")
	@Produces(MediaType.APPLICATION_JSON)
	public String newLeave(LeaveVo leavevo) throws BOException,DAOException, SQLException{
	LeaveDeligate deligate = new LeaveDeligate();
	return deligate.applyLeaveDeligate(leavevo);
	}
	
	
	@POST
	@Path("/leaveapproved")
	@Produces(MediaType.APPLICATION_JSON)
	public String leaveapprove(LeaveVo leavevo) throws DAOException, BOException{
		LeaveDeligate deligate = new LeaveDeligate();
		System.out.println("In resource");
		return deligate.leaveApproveDeligate(leavevo);
		
	}

}
// defaultpath leave
// newleave
// history
// cancelpath

