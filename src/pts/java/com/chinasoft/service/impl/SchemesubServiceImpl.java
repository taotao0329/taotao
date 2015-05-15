package com.chinasoft.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasoft.dao.SchemesubDao;
import com.chinasoft.entities.Schemesub;
import com.chinasoft.service.SchemesubService;

@Service
public class SchemesubServiceImpl implements SchemesubService
{

	@Resource
	private SchemesubDao scheDao;
	@Override
	public Schemesub getSchemesub(String enterpriseTag, String enterpriseName)
	{
		return scheDao.getSchemesub(enterpriseTag, enterpriseName);
	}

}
