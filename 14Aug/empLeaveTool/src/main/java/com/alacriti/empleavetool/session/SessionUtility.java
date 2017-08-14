package com.alacriti.empleavetool.session;

import javax.servlet.http.HttpSession;

public class SessionUtility {

	public boolean checkForSession(HttpSession session) {
		if (session == null)
			return false;
		else
			return true;
	}
}