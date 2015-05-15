package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.PtsScheme;

public interface PtsSchemeDao extends IBaseDAO<PtsScheme>
{
	public List<PtsScheme> getAllPtsScheme();
}
