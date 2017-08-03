package validator;

public class Validation {
	// It will do validation for both user and leaves

	public static boolean oldUserValidator(String email, String passWord) {
		String userName, pass, empId;
		userName = email;
		pass = passWord;
		// empId = employeeId;
		// String userQuery =
		// "select email from amans_empleaveportal_user_profile_tbl where email='userName'";
		String passQuery = "select password from amans_empleaveportal_user_profile_tbl where email='userName'";
		if (pass.equals(passQuery))
			return true;
		else
			return false;

	}
}
