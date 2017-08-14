package com.alacriti.empleaveapp.resteasy.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
	public EmpVo login(EmpAuthVo empvo, @Context HttpServletRequest request) {
		EmployeeDeligate deligate = new EmployeeDeligate();
		System.out.println("In Resource " + empvo.getEmail());
		return deligate.empValidateDeligate(empvo);
	}

	//This Method Will Create a new Employee 
	
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

	public boolean checkSessoin(@Context HttpServletRequest request) {
		SessionUtility sessionUtility = new SessionUtility();
		HttpSession session = request.getSession();
		System.out.println("session in checkSession :" + session);
		return sessionUtility.checkForSession(session);
	}
}
