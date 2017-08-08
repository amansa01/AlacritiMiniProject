package com.alacriti.empleavetool.dao;


public interface EmployeeIdao {
//	Connection getConnection(); 
	boolean checkEmpId();
	boolean checkEmailPass();
	String applyNewLeave();
	String leaveHistory();
	
}
