package com.alacriti.empleaveapp.resteasy.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alacriti.empleavetool.deligate.EmployeeDeligate;
import com.alacriti.empleavetool.session.SessionUtility;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;

@Path("/emp")
public class EmpResource {
	@POST
	@Path("/login")
	// This Method Will Verify the Employee Details and return all The Employee
	// Details if Correct Details are provided
	@Produces(MediaType.APPLICATION_JSON)
	public EmpVo login(EmpAuthVo empAuthVo, @Context HttpServletRequest request) {
		EmployeeDeligate deligate = new EmployeeDeligate();
		EmpVo empvo = new EmpVo();
		SessionUtility sessionUtility = new SessionUtility();
		if (deligate.empValidateDeligate(empAuthVo) != null) {
			sessionUtility.createSession(request, empvo);
		}
		return deligate.empValidateDeligate(empAuthVo);
	}

	// This Method Will Create a new Employee

	@POST
	@Path("/newemp")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean employeeRegistration(EmpVo empvo,
			@Context HttpServletRequest request) {
		EmployeeDeligate deligate = new EmployeeDeligate();
		return deligate.registerEmployee(empvo);
	}

	@GET
	@Path("/checkSession")
	@Produces(MediaType.TEXT_PLAIN)
	// To Check the Employee Session
	public boolean checkSession(@Context HttpServletRequest request) {
		SessionUtility sessionUtility = new SessionUtility();

		HttpSession session = sessionUtility.getSession(request);
		if (session != null) {
			System.out.println("In checkSession :" + session);
			return true;
		} else{
			System.out.println("No session: "+session.getId());
			return false;
		}
		// return sessionUtility.checkForSession(session);
	}

	@GET
	@Path("/clearSession")
	@Produces(MediaType.APPLICATION_JSON)
	// To clear the Employee Session
	public String clearSession(@Context HttpServletRequest request) {
		SessionUtility sessionUtility = new SessionUtility();

		boolean session = sessionUtility.destroySession(request);
		System.out.println("session in checkSession :" + session);
		if (session) {
			// System.out.println("Session Invalidate");
			// session.invalidate();
			return "Session Clear";
		} else
			return "Session Not Clear";
	}
}
