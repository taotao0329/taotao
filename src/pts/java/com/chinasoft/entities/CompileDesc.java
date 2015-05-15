package com.chinasoft.entities;

import java.io.Serializable;
import java.math.BigInteger;

public class CompileDesc implements Serializable
{
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 8662632165938688790L;
	private BigInteger id;
	private BigInteger insCode;
	private BigInteger exeCode;
	private int warningNum;
	private String   warningText;
	private int errNum;
	private String errText;
	private int infoNum;
	private String infoText;
	private String operTime;
	
	private String ciName;
	
	public String getCiName()
	{
		return ciName;
	}
	public void setCiName(String ciName)
	{
		this.ciName = ciName;
	}
	public BigInteger getId()
	{
		return id;
	}
	public void setId(BigInteger id)
	{
		this.id = id;
	}
	public BigInteger getInsCode()
	{
		return insCode;
	}
	public void setInsCode(BigInteger insCode)
	{
		this.insCode = insCode;
	}
	public BigInteger getExeCode()
	{
		return exeCode;
	}
	public void setExeCode(BigInteger exeCode)
	{
		this.exeCode = exeCode;
	}
	public int getWarningNum()
	{
		return warningNum;
	}
	public void setWarningNum(int warningNum)
	{
		this.warningNum = warningNum;
	}
	public String getWarningText()
	{
		return warningText;
	}
	public void setWarningText(String warningText)
	{
		this.warningText = warningText;
	}
	public int getErrNum()
	{
		return errNum;
	}
	public void setErrNum(int errNum)
	{
		this.errNum = errNum;
	}
	public String getErrText()
	{
		return errText;
	}
	public void setErrText(String errText)
	{
		this.errText = errText;
	}
	public int getInfoNum()
	{
		return infoNum;
	}
	public void setInfoNum(int infoNum)
	{
		this.infoNum = infoNum;
	}
	public String getInfoText()
	{
		return infoText;
	}
	public void setInfoText(String infoText)
	{
		this.infoText = infoText;
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
