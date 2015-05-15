package com.chinasoft.dao;

import java.math.BigInteger;
import java.util.List;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.MainInfo;

public interface SubScriptionDao extends IBaseDAO<MainInfo>
{
	    //最大CI
		public Integer getMaxCI(Object [] param);
		//已有CI个数
		public BigInteger CI(Object [] param);
		
		public List<MainInfo> getMainInfo(Object [] param);
}
