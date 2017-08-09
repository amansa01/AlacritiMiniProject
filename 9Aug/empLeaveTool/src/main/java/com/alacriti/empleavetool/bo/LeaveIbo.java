package com.alacriti.empleavetool.bo;

import java.sql.SQLException;

import com.alacriti.empleavetool.bo.impl.BOException;
import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.vo.LeaveVo;

public interface LeaveIbo {

		String applyNewLeaveBo(LeaveVo leavevo) throws DAOException, SQLException,BOException;
	}

