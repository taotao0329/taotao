package com.chinasoft.service;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import com.chinasoft.entities.Permiss;

public interface IPermissService
{
	public List<Permiss> getAccess();
	public Serializable savePermiss(Permiss per);
	public void updatePermiss(Permiss per);
	public void deletePer(long id);
	public Permiss getPermiss(long code);
	public BigInteger validateJF(Object [] param);
}
