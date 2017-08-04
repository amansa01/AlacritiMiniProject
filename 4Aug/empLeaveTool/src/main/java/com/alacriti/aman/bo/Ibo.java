package com.alacriti.aman.bo;

import java.sql.SQLException;

import com.alacriti.aman.vo.EmpVo;


public interface Ibo {
//String leaveHistory();//this will call leaveDetails in Idao

boolean newEmp(EmpVo details) throws SQLException;

//String leaveDetails();
}
