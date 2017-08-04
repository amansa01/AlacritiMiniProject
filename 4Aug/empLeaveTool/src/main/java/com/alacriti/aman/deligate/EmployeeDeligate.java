package com.alacriti.aman.deligate;

import java.sql.SQLException;

import com.alacriti.aman.bo.impl.EmpBoImpl;
import com.alacriti.aman.vo.EmpAuthVo;
import com.alacriti.aman.vo.EmpVo;

public class EmployeeDeligate {

	public boolean empValidateDeligate(EmpAuthVo empvo) throws SQLException {

		EmpBoImpl empboimpl = new EmpBoImpl();
		return empboimpl.empValidatebo(empvo);

	}

	public boolean empAddDeligate(EmpVo empvo) throws SQLException {

		EmpBoImpl empboimpl = new EmpBoImpl();
		return empboimpl.newEmp(empvo);
	}
}
