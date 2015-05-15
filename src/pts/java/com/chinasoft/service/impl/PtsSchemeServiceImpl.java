package com.chinasoft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasoft.dao.PtsSchemeDao;
import com.chinasoft.entities.PtsScheme;
import com.chinasoft.service.PtsSchemeService;

@Service("ptsSche")
public class PtsSchemeServiceImpl implements PtsSchemeService
{

	@Resource
	private PtsSchemeDao ptsDao;
	
	@Override
	public List<PtsScheme> getAllPtsScheme()
	{
		return ptsDao.getAllPtsScheme();
	}

}
