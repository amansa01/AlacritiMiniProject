package com.alacriti.empleaveapp.resteasy.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/leave")
public class LeavesResource {

	@GET
	@Path("/history")
	@Produces(MediaType.TEXT_PLAIN)
	public String history() {
		System.out.println("hi there, I am in history Leave resource");
		return "leave History";

	}

	@GET
	@Path("/cancel")
	@Produces(MediaType.TEXT_PLAIN)
	public String cancel() {
		System.out.println("hi there, I am in cancel Leave resource");
		return "leave Cancel";

	}

	@POST
	@Path("/newleave")
	@Produces(MediaType.TEXT_PLAIN)
	public String newLeave() {
		System.out.println("hi there, I am in New Leave resource");
		return "new leave";

	}

}
// defaultpath leave
// newleave
// history
// cancelpath

