package com.alacriti.empleavetool.bo;

import java.sql.SQLException;

import com.alacriti.empleavetool.bo.impl.BOException;
import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;


public interface Ibo {
//String leaveHistory();//this will call leaveDetails in Idao

boolean registerEmployee(EmpVo details) throws SQLException,DAOException,BOException;
boolean empValidatebo(EmpAuthVo empauthvo) throws SQLException,DAOException,BOException;

//String leaveDetails();
}
