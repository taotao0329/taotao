package com.chinasoft.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "t_ent_scheme_power")
public class Permiss implements Serializable
{
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -5405217914126346150L;
	//标示
	@GenericGenerator(name = "", strategy = "increment")
	@Id
	@GeneratedValue()
	@Column(name = "pk_id", unique = true, nullable = false)
	private long pk_id;
	//方案标示
	@Column(name = "fk_pow_ins_id")
	private long ins_id;
	//授权用户名
	@Column(name = "pow_user")
	private String powUser;
	//授权姓名
	@Column(name = "pow_name")
	private String powName;
	//查看权限0:否；1：是；
	@Column(name = "pow_look")
	private int isLook;
	//执行权限0:否；1：是；
	@Column(name = "pow_execute")
	private int isExe;
	//0:表示项目成员；1：表示特殊用户
	@Column(name = "pow_user_type")
	private int userType;
	//记录操作人
	@Column(name = "pow_recorder")
	private String record;
	//操作时间
	@Column(name = "pow_operate_time")
	private Timestamp operTime;
	//创建时间
	@Column(name = "pow_create_time")
	private Timestamp createTime;
	//是否删除
	@Column(name = "pow_ignore")
	private int ignore;
	public long getPk_id()
	{
		return pk_id;
	}
	public void setPk_id(long pk_id)
	{
		this.pk_id = pk_id;
	}
	public long getIns_id()
	{
		return ins_id;
	}
	public void setIns_id(long ins_id)
	{
		this.ins_id = ins_id;
	}
	public String getPowUser()
	{
		return powUser;
	}
	public void setPowUser(String powUser)
	{
		this.powUser = powUser;
	}
	public String getPowName()
	{
		return powName;
	}
	public void setPowName(String powName)
	{
		this.powName = powName;
	}
	public int getIsLook()
	{
		return isLook;
	}
	public void setIsLook(int isLook)
	{
		this.isLook = isLook;
	}
	public int getIsExe()
	{
		return isExe;
	}
	public void setIsExe(int isExe)
	{
		this.isExe = isExe;
	}
	public int getUserType()
	{
		return userType;
	}
	public void setUserType(int userType)
	{
		this.userType = userType;
	}
	public String getRecord()
	{
		return record;
	}
	public void setRecord(String record)
	{
		this.record = record;
	}
	public Timestamp getOperTime()
	{
		return operTime;
	}
	public void setOperTime(Timestamp operTime)
	{
		this.operTime = operTime;
	}
	public Timestamp getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(Timestamp createTime)
	{
		this.createTime = createTime;
	}
	public int getIgnore()
	{
		return ignore;
	}
	public void setIgnore(int ignore)
	{
		this.ignore = ignore;
	}
	
	
	
}
