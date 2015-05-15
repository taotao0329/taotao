package com.chinasoft.dao;

import java.math.BigInteger;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.InspectionScheme;
import com.chinasoft.entities.MainInfo;

public interface DispactherDao extends IBaseDAO<MainInfo>
{
	public BigInteger validateJF(Object [] param);
}
