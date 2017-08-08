package com.alacriti.empleavetool.deligate;

import com.alacriti.empleavetool.bo.impl.EmpBoImpl;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;

public class EmployeeDeligate {

	public boolean empValidateDeligate(EmpAuthVo empvo) {
		boolean flag = false;
		EmpBoImpl empboimpl = new EmpBoImpl();

		try {
			flag = empboimpl.empValidatebo(empvo);
		} catch (Exception e) {
			System.out.println("Exception occur in empValidateDeligate" + e);
		}
		return flag;

	}

	public boolean registerEmployee(EmpVo empvo) {
		boolean flag = false;
		EmpBoImpl empBoImpl = new EmpBoImpl();

		try {
			flag = empBoImpl.registerEmployee(empvo);
		} catch (Exception e) {
			System.out.println("Exception occur in empAddDeligate" + e);
		}
		return flag;
	}
}
