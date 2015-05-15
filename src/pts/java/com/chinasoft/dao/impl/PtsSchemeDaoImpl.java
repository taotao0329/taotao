package com.chinasoft.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinasoft.dao.PtsSchemeDao;
import com.chinasoft.dbservice.dao.impl.BaseDAOImpl;
import com.chinasoft.entities.PtsScheme;

@Repository
public class PtsSchemeDaoImpl extends BaseDAOImpl<PtsScheme> implements PtsSchemeDao
{

	@Override
	public List<PtsScheme> getAllPtsScheme()
	{
		return this.find("from PtsScheme ps where ps.sch_ignore=0");
	}
	
}
