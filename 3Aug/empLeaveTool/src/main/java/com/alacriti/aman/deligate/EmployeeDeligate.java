package com.alacriti.aman.deligate;

import com.alacriti.aman.bo.impl.BoImpl;
import com.alacriti.aman.vo.EmpVo;

public class EmployeeDeligate {
	//craeteUserDeligate(){
	//	createUserBO()
	// }
	
	public String empDeligate(){
	
		
		EmpVo empVo = new EmpVo();
		
	//	empVo.setContact_no(contact_no);
		
	BoImpl boImpl = new BoImpl();
	System.out.println("Employee Deligate called");
	return boImpl.empBO();
	}
}
