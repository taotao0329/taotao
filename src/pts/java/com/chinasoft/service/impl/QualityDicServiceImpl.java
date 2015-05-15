package com.chinasoft.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasoft.dao.QualityDicDao;
import com.chinasoft.entities.QualityDic;
import com.chinasoft.service.QualityDicService;

@Service("qualityDic")
public class QualityDicServiceImpl implements QualityDicService
{

	@Resource
	private QualityDicDao dicDao;
	
	@Override
	public List<QualityDic> getAllQualityDic(int key)
	{
		return dicDao.getAllQualityDic(key);
	}

	@Override
	public Map<Integer, String> getQualityDic()
	{
		return dicDao.getQualityDic();
	}

	@Override
	public List<QualityDic> getAllQualityDic(String key)
	{
		return dicDao.getAllQualityDic(key);
	}

}
