package com.chinasoft.entities;

import java.io.Serializable;
import java.math.BigInteger;

public class NoticeSys implements Serializable
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 753480494590871748L;
	
	
	
	private BigInteger	noticeCode;
	private String		title;
	private String		text;
	private BigInteger	userCode;
	private String		publishBeginTime;
	private String		publishEndTime;
	private int			messageType;
	private int			status;
	private String		createTime;
	private String		updateTime;
	private String		remark;
	public BigInteger getNoticeCode()
	{
		return noticeCode;
	}
	public void setNoticeCode(BigInteger noticeCode)
	{
		this.noticeCode = noticeCode;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
	}
	public BigInteger getUserCode()
	{
		return userCode;
	}
	public void setUserCode(BigInteger userCode)
	{
		this.userCode = userCode;
	}
	public String getPublishBeginTime()
	{
		return publishBeginTime;
	}
	public void setPublishBeginTime(String publishBeginTime)
	{
		this.publishBeginTime = publishBeginTime;
	}
	public String getPublishEndTime()
	{
		return publishEndTime;
	}
	public void setPublishEndTime(String publishEndTime)
	{
		this.publishEndTime = publishEndTime;
	}
	public int getMessageType()
	{
		return messageType;
	}
	public void setMessageType(int messageType)
	{
		this.messageType = messageType;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	public String getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}
	public String getUpdateTime()
	{
		return updateTime;
	}
	public void setUpdateTime(String updateTime)
	{
		this.updateTime = updateTime;
	}
	public String getRemark()
	{
		return remark;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	
	

}
