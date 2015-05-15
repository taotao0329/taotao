package com.chinasoft.service;

import java.io.Serializable;
import java.util.List;

import com.chinasoft.entities.CompileDesc;
import com.chinasoft.entities.ExecuteScheme;
import com.chinasoft.entities.ResultExeInsp;

public interface IExecuteSchemeService {
	public List<ExecuteScheme> getExe();

	public Serializable saveBuild(long code);

	public List<ResultExeInsp> get(long code);

	public Integer updateBuild(long code);

	public List<CompileDesc> getCompileDesc(long exeId, long inspId);

	/**
	 * 根据项目ID保存检查结果
	 * 
	 * @param projectId
	 * @return
	 */
	public void saveBuildCheckInfo(Long projectId, String operaterName)
			throws Exception;
}
