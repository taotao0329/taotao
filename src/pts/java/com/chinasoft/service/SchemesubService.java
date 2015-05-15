package com.chinasoft.service;

import com.chinasoft.entities.Schemesub;

public interface SchemesubService
{
	/** 获取当前企业所购买的套餐 */
	public Schemesub getSchemesub(String enterpriseTag,String enterpriseName );
}
