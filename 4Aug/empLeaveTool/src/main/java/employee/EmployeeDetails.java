package employee;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import validator.Validation;

public class EmployeeDetails {

	// It will Contain two methods Login and Create a new user
	@GET
	@Path("/loginvalidate")
	public boolean login(String user, String pass) {
		boolean result = Validation.oldUserValidator(user, pass);
		return result;
	}

	@POST
	@Path("/newUser")
	public boolean newUser() {
		return true;
	}

}
// Connection con;
// @GET
// @Path("/conn")
// @Produces(MediaType.TEXT_PLAIN)
// public String test() throws SQLException{
// con= BaseDao.testDb();
// System.out.println("Test");
// return con.getMetaData().getUserName();
// }

// addUser(){
//
// }

/*@POST
@Path("/{param1}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public boolean newUser(@PathParam("param1") String param1)
		throws SQLException {
	// TODO Auto-generated method stub

	Connection con = BaseDao.createConnection();
	PreparedStatement ps = (PreparedStatement) con
			.prepareStatement("select emp_id amans_empleaveportal_emp_master_tbl where emp_id='param1'");
	boolean rs = ps.executeQuery() != null;

	con.close();
	return rs;*/