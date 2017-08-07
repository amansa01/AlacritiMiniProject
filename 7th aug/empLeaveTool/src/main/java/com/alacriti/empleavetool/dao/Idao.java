package com.alacriti.empleavetool.dao;


public interface Idao {
//	Connection getConnection(); 
	boolean checkEmpId();
	boolean checkEmailPass();
	String applyNewLeave();
	String leaveHistory();
	
}
