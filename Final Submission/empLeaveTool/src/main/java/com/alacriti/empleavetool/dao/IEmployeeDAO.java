package com.alacriti.empleavetool.dao;

import java.sql.Connection;

import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;

public interface IEmployeeDAO {
	boolean checkEmpId();

	boolean checkEmailPass();

	String applyNewLeave();

	String leaveHistory();

	boolean checkEmpMaster(EmpVo empdetails);

	boolean createNewEmp(EmpVo empdetails);

	EmpVo empvalidate(EmpAuthVo empauthvo);

	boolean createEmpInfo(EmpVo empdetails, Connection conn);

	boolean createEmpProfile(EmpVo empdetails, Connection conn);

}
