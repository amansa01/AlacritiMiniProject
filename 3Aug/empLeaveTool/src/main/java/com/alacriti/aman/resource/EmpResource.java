package com.alacriti.aman.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.aman.deligate.EmployeeDeligate;

@Path("/emp")
public class EmpResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String dbtest() {
		System.out.println("hi there, I am in respurce");
		EmployeeDeligate deligate = new EmployeeDeligate();
		return deligate.empDeligate();
	}

}


//login
//newuser
