package com.chinasoft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasoft.dao.HistoryRecordDao;
import com.chinasoft.entities.HistoryRecord;
import com.chinasoft.service.HistoryRecordService;

@Service("historyRecord")
public class HistoryRecordServiceImpl implements HistoryRecordService
{

	@Resource
	private HistoryRecordDao his;
	@Override
	public List<HistoryRecord> getHistory(long id)
	{
		return his.getHistory(id);
	}

}
