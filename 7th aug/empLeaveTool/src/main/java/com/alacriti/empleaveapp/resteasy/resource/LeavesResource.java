package com.alacriti.empleaveapp.resteasy.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.empleavetool.deligate.EmployeeDeligate;
import com.alacriti.empleavetool.deligate.LeaveDeligate;

@Path("/leave")
public class LeavesResource {

	@POST
	@Path("/history")
	@Produces(MediaType.APPLICATION_JSON)
	public String history() {
		System.out.println("hi there, I am in history Leave resource");
		return "leave History";

	}

	@POST
	@Path("/cancel")
	@Produces(MediaType.APPLICATION_JSON)
	public String cancel() {
		System.out.println("hi there, I am in cancel Leave resource");
		return "leave Cancel";

	}

	@POST
	@Path("/newleave")
	@Produces(MediaType.APPLICATION_JSON)
	public String newLeave() {
//		LeaveDeligate deligate = new LeaveDeligate();
//		return deligate(applyLeave);
//		System.out.println("hi there, I am in New Leave resource");
		return "new leave";

	}

}
// defaultpath leave
// newleave
// history
// cancelpath

