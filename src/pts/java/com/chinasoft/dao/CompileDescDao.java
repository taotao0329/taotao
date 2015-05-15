package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.CompileDesc;

public interface CompileDescDao extends IBaseDAO<CompileDesc>
{
	public List<CompileDesc> getCompileDesc(long exeId,long inspId);
}
