package com.alacriti.aman.bo.impl;

import java.sql.SQLException;

import com.alacriti.aman.bo.Ibo;
import com.alacriti.aman.dao.impl.EmpDao;
import com.alacriti.aman.vo.EmpVo;

/*
public class BoImpl implements Ibo{

	public boolean newEmp(EmpVo details) throws SQLException {
		boolean newEmpCreationResult= EmpDao.createNewEmp(details);
		return newEmpCreationResult;
	}
	
	public boolean empBO() throws SQLException{
		
		System.out.println("In Emp BO Method");
		EmpDao dao = new EmpDao();
		EmpVo empdetails = null;
		return EmpDao.createNewEmp(empdetails);
	}
	/*
	 * @GET
	 * 
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public String newUser() throws
	 * SQLException { // TODO Auto-generated method stub Connection con =
	 * BaseDao.testDb();
	 * 
	 * return con.getMetaData().getUserName(); }
	 */




//}
