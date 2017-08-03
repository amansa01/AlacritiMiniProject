package com.alacriri.aman.dao;

import java.sql.Connection;

public interface Idao {
//	Connection getConnection(); 
	boolean checkEmpId();
	boolean checkEmailPass();
	String applyNewLeave();
	String leaveHistory();
	
}
