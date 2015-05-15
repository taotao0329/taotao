package com.chinasoft.dao;

import java.io.Serializable;
import java.util.List;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.ExecuteScheme;

public interface IExecuteSchemeDao extends IBaseDAO<ExecuteScheme> {
	public List<ExecuteScheme> getExe();

	public Serializable saveBuild(long code);

	// public List<ResultExeInsp> get(long code);
	public Integer updateBuild(long code);

	// public List<CompileDesc> getCompileDesc();

	/**
	 * 根据proId获取最后一次执行记录
	 * 
	 * @param proId
	 * @return
	 */
	public ExecuteScheme getMaxExecuteSchemeByProjectId(Long proId)
			throws Exception;
}
