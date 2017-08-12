package com.alacriti.empleavetool.bo.impl;

import com.alacriti.empleavetool.bo.EmployeeIbo;
import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.dao.impl.EmpDao;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;

public class EmpBoImpl implements EmployeeIbo {

	public boolean registerEmployee(EmpVo details) throws DAOException,
			BOException {

		boolean flag = false;
		EmpDao empDao = new EmpDao();

		try {
			flag = empDao.createNewEmp(details);
		} catch (Exception e) {
			System.out.println("Exception occur in newEmp() " + e);
			throw new BOException();
		}
		return flag;
	}

	public EmpVo empValidatebo(EmpAuthVo empauthvo) throws DAOException,
			BOException {
		boolean flag = false;
		EmpDao empdao = new EmpDao();
		EmpVo empvo=new EmpVo();

		try {
			System.out.println("In Bo " + empauthvo.getEmail());
			empvo = empdao.empvalidate(empauthvo);
		} catch (Exception e) {
			System.out.println("Exception occur in empValidatebo()" + e);
			throw new BOException();
		}
		return empvo;
	}

}
//public boolean empValidatebo(EmpAuthVo empauthvo) throws DAOException,
//BOException {
//boolean flag = false;
//EmpDao empdao = new EmpDao();
//
//try {
//flag = empdao.empvalidate(empauthvo);
//} catch (Exception e) {
//System.out.println("Exception occur in empValidatebo()" + e);
//throw new BOException();
//}
//return flag;
//}