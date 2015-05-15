package com.chinasoft.entities;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 方案&订购服务实体
 * @author admin
 *
 */
public class Schemesub implements Serializable
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -2751395632401881627L;
	//方案标识
	private BigInteger scheCode;
	//方案名称
	private String scheName;
	//方案类型
	private int scheType;
	//最大项目个数
	private int scheMaxProject;
	//最大CI方案个数
	private int scheMaxCi;
	//服务有效期
	private int scheServiceVali;
	//服务维度
	private String scheDiments;
	//订购标识
	private BigInteger subCode;
	//订购企业的email
	private String subEmail;
	//企业联系人
	private String subContact;
	//联系电话
	private String subPhone;
	//订购方案开始时间
	private String subStartTime;
	//订购方案结束时间
	private String subEndTime;
	//服务是否生效 (Y/N)
	private String isEff;
	public BigInteger getScheCode()
	{
		return scheCode;
	}
	public void setScheCode(BigInteger scheCode)
	{
		this.scheCode = scheCode;
	}
	public String getScheName()
	{
		return scheName;
	}
	public void setScheName(String scheName)
	{
		this.scheName = scheName;
	}
	public int getScheType()
	{
		return scheType;
	}
	public void setScheType(int scheType)
	{
		this.scheType = scheType;
	}
	public int getScheMaxProject()
	{
		return scheMaxProject;
	}
	public void setScheMaxProject(int scheMaxProject)
	{
		this.scheMaxProject = scheMaxProject;
	}
	public int getScheMaxCi()
	{
		return scheMaxCi;
	}
	public void setScheMaxCi(int scheMaxCi)
	{
		this.scheMaxCi = scheMaxCi;
	}
	public int getScheServiceVali()
	{
		return scheServiceVali;
	}
	public void setScheServiceVali(int scheServiceVali)
	{
		this.scheServiceVali = scheServiceVali;
	}
	public String getScheDiments()
	{
		return scheDiments;
	}
	public void setScheDiments(String scheDiments)
	{
		this.scheDiments = scheDiments;
	}
	public BigInteger getSubCode()
	{
		return subCode;
	}
	public void setSubCode(BigInteger subCode)
	{
		this.subCode = subCode;
	}
	public String getSubEmail()
	{
		return subEmail;
	}
	public void setSubEmail(String subEmail)
	{
		this.subEmail = subEmail;
	}
	public String getSubContact()
	{
		return subContact;
	}
	public void setSubContact(String subContact)
	{
		this.subContact = subContact;
	}
	public String getSubPhone()
	{
		return subPhone;
	}
	public void setSubPhone(String subPhone)
	{
		this.subPhone = subPhone;
	}
	public String getSubStartTime()
	{
		return subStartTime;
	}
	public void setSubStartTime(String subStartTime)
	{
		this.subStartTime = subStartTime;
	}
	public String getSubEndTime()
	{
		return subEndTime;
	}
	public void setSubEndTime(String subEndTime)
	{
		this.subEndTime = subEndTime;
	}
	public String getIsEff()
	{
		return isEff;
	}
	public void setIsEff(String isEff)
	{
		this.isEff = isEff;
	}
	
	
}
