package com.chinasoft.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.Permiss;

public interface IPermissDao extends IBaseDAO<Permiss>
{
	public List<Permiss> getAccess();
	public Serializable savePermiss(Permiss per);
	public void updatePermiss(Permiss per);
	public void deletePer(long id);
	public Permiss getPermiss(long code);
	public BigInteger validateJF(Object [] param);
}
