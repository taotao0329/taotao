package com.chinasoft.dao;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.ExeResuEnti;

public interface ExeResuEntiDao extends IBaseDAO<ExeResuEnti>
{
	/** 获取某个CI方案的某次构建下的子指标 权重 */
	public ExeResuEnti getExeResu(long key1,long key2,String name);
}
