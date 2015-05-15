package com.chinasoft.entities;

import java.io.Serializable;

public class ExeResuEnti implements Serializable
{
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1220339120353313640L;
	private String target;
	private String result;
	private String score;
	public String getTarget()
	{
		return target;
	}
	public void setTarget(String target)
	{
		this.target = target;
	}
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result = result;
	}
	public String getScore()
	{
		return score;
	}
	public void setScore(String score)
	{
		this.score = score;
	}
	
}
