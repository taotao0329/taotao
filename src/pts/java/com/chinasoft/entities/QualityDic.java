package com.chinasoft.entities;

import java.io.Serializable;
import java.math.BigInteger;

public class QualityDic implements Serializable
{
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -2297862890387334051L;
	private BigInteger code;
	private Integer tag;
	private String dimension;
	private String parentTag;
	private String childTag;
	private String dimPer;
	private String tagPer;
	private String unit;
	private String formula;
	private String score;
	public BigInteger getCode()
	{
		return code;
	}
	public void setCode(BigInteger code)
	{
		this.code = code;
	}
	
	public Integer getTag()
	{
		return tag;
	}
	public void setTag(Integer tag)
	{
		this.tag = tag;
	}
	public String getDimension()
	{
		return dimension;
	}
	public void setDimension(String dimension)
	{
		this.dimension = dimension;
	}
	public String getParentTag()
	{
		return parentTag;
	}
	public void setParentTag(String parentTag)
	{
		this.parentTag = parentTag;
	}
	public String getChildTag()
	{
		return childTag;
	}
	public void setChildTag(String childTag)
	{
		this.childTag = childTag;
	}
	public String getDimPer()
	{
		return dimPer;
	}
	public void setDimPer(String dimPer)
	{
		this.dimPer = dimPer;
	}
	public String getTagPer()
	{
		return tagPer;
	}
	public void setTagPer(String tagPer)
	{
		this.tagPer = tagPer;
	}
	public String getUnit()
	{
		return unit;
	}
	public void setUnit(String unit)
	{
		this.unit = unit;
	}
	public String getFormula()
	{
		return formula;
	}
	public void setFormula(String formula)
	{
		this.formula = formula;
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
