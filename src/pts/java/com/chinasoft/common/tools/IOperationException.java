package com.chinasoft.common.tools;

public class IOperationException extends OperationException
{
	
	public IOperationException(String msg) {
		super(msg);
	}

	public IOperationException(String msg, Exception ex) {
		super(msg, ex);
	}
}
