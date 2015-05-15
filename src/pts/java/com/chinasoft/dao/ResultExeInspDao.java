package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.ResultExeInsp;

public interface ResultExeInspDao extends IBaseDAO<ResultExeInsp>
{
	public List<ResultExeInsp> get(long code);
}
