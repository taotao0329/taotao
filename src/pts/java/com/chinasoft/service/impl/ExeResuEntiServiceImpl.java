package com.chinasoft.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasoft.dao.ExeResuEntiDao;
import com.chinasoft.entities.ExeResuEnti;
import com.chinasoft.service.ExeResuEntiService;

@Service
public class ExeResuEntiServiceImpl implements ExeResuEntiService
{

	@Resource
	private ExeResuEntiDao exeDao;
	@Override
	public ExeResuEnti getExeResu(long key1, long key2, String name)
	{
		return exeDao.getExeResu(key1, key2, name);
	}

}
