package com.alacriti.aman.bo.impl;

import java.sql.SQLException;

import com.alacriti.aman.bo.Ibo;
import com.alacriti.aman.dao.impl.EmpDao;
import com.alacriti.aman.vo.EmpAuthVo;
import com.alacriti.aman.vo.EmpVo;

public class EmpBoImpl implements Ibo {

	public boolean newEmp(EmpVo details) throws SQLException {
		EmpDao empdao = new EmpDao();

		return empdao.createNewEmp(details);
	}
	
	public boolean empValidatebo(EmpAuthVo empauthvo) throws SQLException
	{
		EmpDao empdao =new EmpDao();
		
		return empdao.empvalidate(empauthvo);
	}

}
