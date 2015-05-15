package com.chinasoft.entities;

import java.io.Serializable;

public class MainInfo implements Serializable
{
	private String maxPro;
	private String maxCi;
	private String proNum;
	private String scheName;
	private String diment;
	public String getMaxPro()
	{
		return maxPro;
	}
	public void setMaxPro(String maxPro)
	{
		this.maxPro = maxPro;
	}
	public String getMaxCi()
	{
		return maxCi;
	}
	public void setMaxCi(String maxCi)
	{
		this.maxCi = maxCi;
	}
	public String getProNum()
	{
		return proNum;
	}
	public void setProNum(String proNum)
	{
		this.proNum = proNum;
	}
	public String getScheName()
	{
		return scheName;
	}
	public void setScheName(String scheName)
	{
		this.scheName = scheName;
	}
	public String getDiment()
	{
		return diment;
	}
	public void setDiment(String diment)
	{
		this.diment = diment;
	}
	
}
