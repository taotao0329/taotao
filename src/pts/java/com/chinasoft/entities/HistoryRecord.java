package com.chinasoft.entities;

import java.io.Serializable;
import java.math.BigInteger;

public class HistoryRecord implements Serializable
{
	private BigInteger exeId;
	private BigInteger inspId;
	private String scheName;
	private String createTime;
	private String state;
	private String odds;
	public BigInteger getExeId()
	{
		return exeId;
	}
	public void setExeId(BigInteger exeId)
	{
		this.exeId = exeId;
	}
	public BigInteger getInspId()
	{
		return inspId;
	}
	public void setInspId(BigInteger inspId)
	{
		this.inspId = inspId;
	}
	public String getScheName()
	{
		return scheName;
	}
	public void setScheName(String scheName)
	{
		this.scheName = scheName;
	}
	public String getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getOdds()
	{
		return odds;
	}
	public void setOdds(String odds)
	{
		this.odds = odds;
	}
	
	
	
	
}
