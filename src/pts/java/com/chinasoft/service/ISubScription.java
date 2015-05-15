package com.chinasoft.service;

import java.math.BigInteger;
import java.util.List;

import com.chinasoft.entities.MainInfo;

public interface ISubScription
{
	//最大CI
	public Integer getMaxCI(Object [] param);
	//已有CI个数
	public BigInteger CI(Object [] param);
	public List<MainInfo> getMainInfo(Object [] param);
}
