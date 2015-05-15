package com.chinasoft.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.dao.SubScriptionDao;
import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.MainInfo;
import com.chinasoft.service.ISubScription;

@Service("sub")
public class SubScriptionImpl implements ISubScription
{

	/*@Autowired
	private IBaseDAO<Object> dao;*/
	@Resource
	private SubScriptionDao dao;
	
	@Override
	public Integer getMaxCI(Object[] param)
	{
		return dao.getMaxCI(param);
	}

	@Override
	public BigInteger CI(Object[] param)
	{
		return dao.CI(param);
	}

	@Override
	public List<MainInfo> getMainInfo(Object[] param)
	{
		return dao.getMainInfo(param);
	}

}
