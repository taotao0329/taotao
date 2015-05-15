package com.chinasoft.service.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.dao.IPermissDao;
import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.Permiss;
import com.chinasoft.service.IPermissService;

@Service("permissService")
public class PermissServiceImpl implements IPermissService
{

	
//	@Autowired
//	private IBaseDAO<Permiss> dao;
	@Resource
	private IPermissDao dao;
	
	@Override
	public List<Permiss> getAccess()
	{
		return dao.getAccess();
	}//getAccess

	@Override
	public Serializable savePermiss(Permiss per)
	{
		return dao.savePermiss(per);
	}//savePermiss

	@Override
	public void updatePermiss(Permiss per)
	{
		 dao.updatePermiss(per);
	}//updatePermiss

	@Override
	public void deletePer(long id)
	{
		dao.deletePer(id);
	}//deletePer

	@Override
	public Permiss getPermiss(long code)
	{
		return dao.getPermiss(code);
	}//getPermiss

	@Override
	public BigInteger validateJF(Object [] param)
	{
		return dao.validateJF(param);
	}

}
