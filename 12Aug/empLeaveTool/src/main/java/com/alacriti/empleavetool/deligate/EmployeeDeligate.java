package com.alacriti.empleavetool.deligate;

import com.alacriti.empleavetool.bo.impl.EmpBoImpl;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;

public class EmployeeDeligate {

	public EmpVo empValidateDeligate(EmpAuthVo empauth) {
		boolean flag = false;
		EmpBoImpl empboimpl = new EmpBoImpl();
		EmpVo empvo= new EmpVo();

		try {
			System.out.println("In Deligate " + empauth.getEmail());
			empvo = empboimpl.empValidatebo(empauth);
		} catch (Exception e) {
			System.out.println("Exception occur in empValidateDeligate" + e);
		}
		return empvo;

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

	public boolean isFlag() {
		
		return false;
	}
}
//public boolean empValidateDeligate(EmpAuthVo empvo) {
//	boolean flag = false;
//	EmpBoImpl empboimpl = new EmpBoImpl();
//
//	try {
//		flag = empboimpl.empValidatebo(empvo);
//	} catch (Exception e) {
//		System.out.println("Exception occur in empValidateDeligate" + e);
//	}
//	return flag;
//
//}