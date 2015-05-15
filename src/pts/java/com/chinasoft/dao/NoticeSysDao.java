package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.NoticeSys;

public interface NoticeSysDao extends IBaseDAO<NoticeSys>
{
	public List<NoticeSys> get();
}
