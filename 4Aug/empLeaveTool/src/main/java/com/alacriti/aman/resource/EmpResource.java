package com.alacriti.aman.resource;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.aman.deligate.EmployeeDeligate;
import com.alacriti.aman.vo.EmpAuthVo;
import com.alacriti.aman.vo.EmpVo;

@Path("/emp")
public class EmpResource {
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean login(EmpAuthVo empvo) throws SQLException {
		EmployeeDeligate deligate = new EmployeeDeligate();
		return deligate.empValidateDeligate(empvo);
	}
	
	@POST
	@Path("/newemp")
	@Produces(MediaType.APPLICATION_JSON)
		public boolean createNewEmp(EmpVo empvo) throws SQLException {
		System.out.println("hi there, I am in new employee resource");
		EmpVo emp= new EmpVo();
		System.out.println("hi there, I am in new employee resource" + empvo.getEmpId());
		EmployeeDeligate deligate = new EmployeeDeligate();
		return deligate.empAddDeligate(empvo);
	}

}

// login
// newuser
