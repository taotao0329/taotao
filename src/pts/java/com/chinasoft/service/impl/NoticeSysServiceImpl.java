package com.chinasoft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasoft.dao.NoticeSysDao;
import com.chinasoft.entities.NoticeSys;
import com.chinasoft.service.NoticeSysService;

@Service("noticeSys")
public class NoticeSysServiceImpl implements NoticeSysService
{

	@Resource
	private NoticeSysDao sysDao;
	@Override
	public List<NoticeSys> get()
	{
		return sysDao.get();
	}

}
