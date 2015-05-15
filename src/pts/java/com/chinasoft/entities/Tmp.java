package com.chinasoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "tbl_tmp", catalog = "test")
public class Tmp implements java.io.Serializable
{
	
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 200615996822950L;

	@GenericGenerator(name = "test", strategy = "increment")
	@Id
	@GeneratedValue(generator = "test")
	@Column(name = "tid", unique = true, nullable = false)
	private int tid;
	
	@Column(name = "tmpName", length = 500)
	private String tmpName;
	
	@Column(name = "tmpCode", length = 10)
	private int tmpCode;
	
	public int getTid()
	{
		return tid;
	}
	public void setTid(int tid)
	{
		this.tid = tid;
	}
	public String getTmpName()
	{
		return tmpName;
	}
	public void setTmpName(String tmpName)
	{
		this.tmpName = tmpName;
	}
	public int getTmpCode()
	{
		return tmpCode;
	}
	public void setTmpCode(int tmpCode)
	{
		this.tmpCode = tmpCode;
	}
	
	
}
