package com.alacriti.empleaveapp.resteasy.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.empleavetool.deligate.EmployeeDeligate;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;

@Path("/emp")
public class EmpResource {
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean login(EmpAuthVo empvo) {
		EmployeeDeligate deligate = new EmployeeDeligate();
		return deligate.empValidateDeligate(empvo);
	}

	@POST
	@Path("/newemp")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean employeeRegistration(EmpVo empvo) {
		EmployeeDeligate deligate = new EmployeeDeligate();
		return deligate.registerEmployee(empvo);
	}

}

