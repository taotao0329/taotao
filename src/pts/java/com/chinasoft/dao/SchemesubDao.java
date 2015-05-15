package com.chinasoft.dao;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.Schemesub;

public interface SchemesubDao extends IBaseDAO<Schemesub>
{
	/** 获取当前企业所购买的套餐 */
	public Schemesub getSchemesub(String enterpriseTag,String enterpriseName );
}
