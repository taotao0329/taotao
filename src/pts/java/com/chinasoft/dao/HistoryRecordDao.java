package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.HistoryRecord;

public interface HistoryRecordDao extends IBaseDAO<HistoryRecord>
{
	/**
	 * 获取某个方案下的构建历史
	 * @param id
	 * @return
	 */
	public List<HistoryRecord> getHistory(long id);
}
