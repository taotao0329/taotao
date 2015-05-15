package com.chinasoft.common.tools;

public class OperationException extends RuntimeException
{
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 2719598565721803769L;

	/**
	 * default constructor
	 */
	public OperationException()
	{
		
	}
	
	public OperationException(String xception)
	{
		super(xception);
	}
	
	public OperationException(Exception exception)
	{
		super(exception);
	}
	
	public OperationException(String msg, Exception exception)
	{
		super(msg,exception);
	}
	
	public OperationException(String msg,Throwable cause)
	{
		super(msg,cause);
	}
}
