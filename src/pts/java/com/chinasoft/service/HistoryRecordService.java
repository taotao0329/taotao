package com.chinasoft.service;

import java.util.List;

import com.chinasoft.entities.HistoryRecord;

public interface HistoryRecordService
{
	public List<HistoryRecord> getHistory(long id);
}
