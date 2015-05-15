package com.chinasoft.entities;

import java.io.Serializable;
import java.math.BigInteger;


/**
 * 
 * @author admin
 *
 */
public class ResultExeInsp implements  Serializable
{
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -2849269343319371982L;
	
	
	private BigInteger id;
	private String gitName;
	private String gitBranch;
	private String scheme;
	private String state;
	private String odds;
	private String operTime;
	private BigInteger code;
	
	public BigInteger getCode()
	{
		return code;
	}
	public void setCode(BigInteger code)
	{
		this.code = code;
	}
	public BigInteger getId()
	{
		return id;
	}
	public void setId(BigInteger id)
	{
		this.id = id;
	}
	public String getGitName()
	{
		return gitName;
	}
	public void setGitName(String gitName)
	{
		this.gitName = gitName;
	}
	public String getGitBranch()
	{
		return gitBranch;
	}
	public void setGitBranch(String gitBranch)
	{
		this.gitBranch = gitBranch;
	}
	public String getScheme()
	{
		return scheme;
	}
	public void setScheme(String scheme)
	{
		this.scheme = scheme;
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
	public String getOperTime()
	{
		return operTime;
	}
	public void setOperTime(String operTime)
	{
		this.operTime = operTime;
	}
	
	
}
