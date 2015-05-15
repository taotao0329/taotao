package com.chinasoft.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.chinasoft.dao.CompileDescDao;
import com.chinasoft.dao.IExecuteSchemeDao;
import com.chinasoft.dao.InspectionDao;
import com.chinasoft.dao.ResultExeInspDao;
import com.chinasoft.dao.TEntExecuteResultDao;
import com.chinasoft.dao.TEntReportDescDao;
import com.chinasoft.entities.CompileDesc;
import com.chinasoft.entities.ExecuteScheme;
import com.chinasoft.entities.InspectionScheme;
import com.chinasoft.entities.NormDesc;
import com.chinasoft.entities.ResultExeInsp;
import com.chinasoft.entities.TEntExecuteResult;
import com.chinasoft.entities.TEntReportDesc;
import com.chinasoft.service.IExecuteSchemeService;
import com.sonar.dao.SonarDao;

@Service("executeScheme")
public class IExecuteSchemeImpl implements IExecuteSchemeService {

	/*
	 * @Autowired private IBaseDAO dao;
	 */
	@Resource
	private IExecuteSchemeDao dao;
	@Resource
	private CompileDescDao dao2;
	@Resource
	private ResultExeInspDao dao3;

	@Resource
	private InspectionDao inspectionDao;

	@Resource
	private TEntExecuteResultDao resultDao;

	@Resource
	private TEntReportDescDao reportDescDao;

	@Override
	public List<ExecuteScheme> getExe() {
		return dao.getExe();
	}// getExe

	@Override
	public Serializable saveBuild(long code) {

		return dao.saveBuild(code);
	}// saveBuild

	@Override
	public List<ResultExeInsp> get(long code) {
		return dao3.get(code);
	}// get

	@Override
	public Integer updateBuild(long code) {
		return this.updateBuild(code);
	}// updateBuild

	@Override
	public List<CompileDesc> getCompileDesc(long exeId, long inspId) {
		return this.dao2.getCompileDesc(exeId, inspId);
	}// getCompileDesc

	@Override
	public void saveBuildCheckInfo(Long projectId, String operaterName)
			throws Exception {

		InspectionScheme inspectionScheme = inspectionDao.get(
				InspectionScheme.class, projectId);
		// 需要检测的维度
		String[] diment = inspectionScheme.getIns_check_diment().split(",");
		// 获取方案检查执行记录
		ExecuteScheme exeHistory = dao
				.getMaxExecuteSchemeByProjectId(projectId);
		// 保存项目信息基本信息

		this.saveCodeCount(projectId, exeHistory.getPk_id(), operaterName);
		// 保存执行结果汇总数据
		this.saveBuildResult(projectId, exeHistory.getPk_id(), diment,
				operaterName);
	}

	/**
	 * 保存项目代码基本信息
	 * 
	 * @param projectId
	 * @param exeHistoryID
	 * @param operaterName
	 */
	public void saveCodeCount(Long projectId, Long exeHistoryID,
			String operaterName) {
		SonarDao sd = new SonarDao();
		// 总行数
		Integer totalLines = sd.getTotalLines(projectId);
		// 非注释代码总行数
		Integer noCommentLines = sd.getNoCommentLines(projectId);
		// 文件个数
		Integer fileCount = sd.getFileCount(projectId);
		// 方法数量
		Integer functionCount = sd.getFunctionCount(projectId);
		// 类数量
		Integer classesCount = sd.getClassesCount(projectId);
		// 目录数量
		Integer dirCount = sd.getDirCount(projectId);
		// 注释总行数
		Integer commentLineCount = totalLines - noCommentLines;

		ExecuteScheme exeHistory = dao.get(ExecuteScheme.class, exeHistoryID);
		exeHistory.setCode_total_lines(Long.parseLong(totalLines.toString()));
		exeHistory
				.setNo_comment_lines(Long.parseLong(noCommentLines.toString()));
		exeHistory.setFile_num(Long.parseLong(fileCount.toString()));
		exeHistory.setFunction_num(Long.parseLong(functionCount.toString()));
		exeHistory.setClasses_num(Long.parseLong(classesCount.toString()));
		exeHistory.setDirectory_num(Long.parseLong(dirCount.toString()));
		exeHistory
				.setComment_lines(Long.parseLong(commentLineCount.toString()));
		dao.merge(exeHistory);
	}

	/**
	 * 插入执行结果数据
	 * 
	 * @param projectId
	 * @param exeHistoryID
	 * @param diment
	 * @return
	 */
	public void saveBuildResult(Long projectId, Long exeHistoryID,
			String[] diments, String operaterName) throws Exception {
		SonarDao sd = new SonarDao();
		Timestamp t = new Timestamp(System.currentTimeMillis());
		for (String diment : diments) {
			// 保存可维护维度数据
			if (diment.equals("1")) {
				// // 最大圈复杂度
				// double result = sd.getMaxComplexity(projectId);
				// TEntExecuteResult buildResult = new TEntExecuteResult();
				// buildResult.setFkResInsId(Long.parseLong(projectId.toString()));
				// buildResult.setFkResExeId(exeHistoryID);
				// buildResult.setFkResAssId(Long.parseLong("1"));
				// buildResult.setResTarget("最大圈复杂度");
				// buildResult.setResTargetResult((float) result);
				// buildResult.setResIgnore(0);
				// buildResult.setResRecorder(operaterName);
				// buildResult.setResOperateTime(t);
				// buildResult.setResCreateTime(t);
				// buildResult.setResTargetScore((float) 0);
				// this.resultDao.save(buildResult);
				//
				// // 最小圈复杂度
				// double result1 = sd.getMinComplexity(projectId);
				// TEntExecuteResult buildResult1 = new TEntExecuteResult();
				// buildResult1
				// .setFkResInsId(Long.parseLong(projectId.toString()));
				// buildResult1.setFkResExeId(exeHistoryID);
				// buildResult1.setFkResAssId(Long.parseLong("1"));
				// buildResult1.setResTarget("最小圈复杂度");
				// buildResult1.setResTargetResult((float) result1);
				// buildResult1.setResIgnore(0);
				// buildResult1.setResRecorder(operaterName);
				// buildResult1.setResOperateTime(t);
				// buildResult1.setResCreateTime(t);
				// buildResult1.setResTargetScore((float) 0);
				// this.resultDao.save(buildResult1);
				//
				// // 平均圈复杂度
				// double result2 = sd.getMinComplexity(projectId);
				// TEntExecuteResult buildResult2 = new TEntExecuteResult();
				// buildResult2
				// .setFkResInsId(Long.parseLong(projectId.toString()));
				// buildResult2.setFkResExeId(exeHistoryID);
				// buildResult2.setFkResAssId(Long.parseLong("1"));
				// buildResult2.setResTarget("最小圈复杂度");
				// buildResult2.setResTargetResult((float) result2);
				// buildResult2.setResIgnore(0);
				// buildResult2.setResRecorder(operaterName);
				// buildResult2.setResOperateTime(t);
				// buildResult2.setResCreateTime(t);
				// buildResult2.setResTargetScore((float) 0);
				// this.resultDao.save(buildResult2);
				//
				// // 代码重复行
				// double result3 = sd.getRepetitionLine(projectId);
				// TEntExecuteResult buildResult3 = new TEntExecuteResult();
				// buildResult3
				// .setFkResInsId(Long.parseLong(projectId.toString()));
				// buildResult3.setFkResExeId(exeHistoryID);
				// buildResult3.setFkResAssId(Long.parseLong("1"));
				// buildResult3.setResTarget("代码重复行");
				// buildResult3.setResTargetResult((float) result3);
				// buildResult3.setResIgnore(0);
				// buildResult3.setResRecorder(operaterName);
				// buildResult3.setResOperateTime(t);
				// buildResult3.setResCreateTime(t);
				// buildResult3.setResTargetScore((float) 0);
				// this.resultDao.save(buildResult3);
				//
				// // 代码重复块
				// double result4 = sd.getRepetitionBlocks(projectId);
				// TEntExecuteResult buildResult4 = new TEntExecuteResult();
				// buildResult4
				// .setFkResInsId(Long.parseLong(projectId.toString()));
				// buildResult4.setFkResExeId(exeHistoryID);
				// buildResult4.setFkResAssId(Long.parseLong("1"));
				// buildResult4.setResTarget("代码重复块");
				// buildResult4.setResTargetResult((float) result4);
				// buildResult4.setResIgnore(0);
				// buildResult4.setResRecorder(operaterName);
				// buildResult4.setResOperateTime(t);
				// buildResult4.setResCreateTime(t);
				// buildResult4.setResTargetScore((float) 0);
				// this.resultDao.save(buildResult4);
				// // 代码重复率
				// double result5 = sd.getRepetitionProportion(projectId);
				// TEntExecuteResult buildResult5 = new TEntExecuteResult();
				// buildResult5
				// .setFkResInsId(Long.parseLong(projectId.toString()));
				// buildResult5.setFkResExeId(exeHistoryID);
				// buildResult5.setFkResAssId(Long.parseLong("1"));
				// buildResult5.setResTarget("代码重复率");
				// buildResult5.setResTargetResult((float) result5);
				// buildResult5.setResIgnore(0);
				// buildResult5.setResRecorder(operaterName);
				// buildResult5.setResOperateTime(t);
				// buildResult5.setResCreateTime(t);
				// buildResult5.setResTargetScore((float) 0);
				// this.resultDao.save(buildResult5);
				// // 注释率
				// double result6 = sd.getCommentLinesDensity(projectId);
				// TEntExecuteResult buildResult6 = new TEntExecuteResult();
				// buildResult6
				// .setFkResInsId(Long.parseLong(projectId.toString()));
				// buildResult6.setFkResExeId(exeHistoryID);
				// buildResult6.setFkResAssId(Long.parseLong("1"));
				// buildResult6.setResTarget("注释率");
				// buildResult6.setResTargetResult((float) result6);
				// buildResult6.setResIgnore(0);
				// buildResult6.setResRecorder(operaterName);
				// buildResult6.setResOperateTime(t);
				// buildResult6.setResCreateTime(t);
				// buildResult6.setResTargetScore((float) 0);
				// this.resultDao.save(buildResult6);
			}
			// 可维护
			if (diment.equals("2")) {

				// 注释率
				double result6 = sd.getCommentLinesDensity(projectId);
				TEntExecuteResult buildResult6 = new TEntExecuteResult();
				buildResult6
						.setFkResInsId(Long.parseLong(projectId.toString()));
				buildResult6.setFkResExeId(exeHistoryID);
				buildResult6.setFkResAssId(Long.parseLong("1"));
				buildResult6.setResTarget("注释率");
				buildResult6.setResTargetResult((float) result6);
				buildResult6.setResIgnore(0);
				buildResult6.setResRecorder(operaterName);
				buildResult6.setResOperateTime(t);
				buildResult6.setResCreateTime(t);
				buildResult6.setResTargetScore((float) 0);
				this.resultDao.save(buildResult6);

			}
			// 代码分析
			if (diment.equals("3")) {
				// 阻断
				double result7 = sd.getBlockerCount(projectId);
				TEntExecuteResult buildResult7 = new TEntExecuteResult();
				buildResult7
						.setFkResInsId(Long.parseLong(projectId.toString()));
				buildResult7.setFkResExeId(exeHistoryID);
				buildResult7.setFkResAssId(Long.parseLong("1"));
				buildResult7.setResTarget("阻断");
				buildResult7.setResTargetResult((float) result7);
				buildResult7.setResIgnore(0);
				buildResult7.setResRecorder(operaterName);
				buildResult7.setResOperateTime(t);
				buildResult7.setResCreateTime(t);
				buildResult7.setResTargetScore((float) 0);
				this.resultDao.save(buildResult7);

				// 严重
				double result8 = sd.getCriticalCount(projectId);
				TEntExecuteResult buildResult8 = new TEntExecuteResult();
				buildResult8
						.setFkResInsId(Long.parseLong(projectId.toString()));
				buildResult8.setFkResExeId(exeHistoryID);
				buildResult8.setFkResAssId(Long.parseLong("1"));
				buildResult8.setResTarget("严重");
				buildResult8.setResTargetResult((float) result8);
				buildResult8.setResIgnore(0);
				buildResult8.setResRecorder(operaterName);
				buildResult8.setResOperateTime(t);
				buildResult8.setResCreateTime(t);
				buildResult8.setResTargetScore((float) 0);
				this.resultDao.save(buildResult8);

				// 主要
				double result9 = sd.getMajorCount(projectId);
				TEntExecuteResult buildResult9 = new TEntExecuteResult();
				buildResult9
						.setFkResInsId(Long.parseLong(projectId.toString()));
				buildResult9.setFkResExeId(exeHistoryID);
				buildResult9.setFkResAssId(Long.parseLong("1"));
				buildResult9.setResTarget("主要");
				buildResult9.setResTargetResult((float) result9);
				buildResult9.setResIgnore(0);
				buildResult9.setResRecorder(operaterName);
				buildResult9.setResOperateTime(t);
				buildResult9.setResCreateTime(t);
				buildResult9.setResTargetScore((float) 0);
				this.resultDao.save(buildResult9);

				// 次要
				double result10 = sd.getMinorCount(projectId);
				TEntExecuteResult buildResult10 = new TEntExecuteResult();
				buildResult10
						.setFkResInsId(Long.parseLong(projectId.toString()));
				buildResult10.setFkResExeId(exeHistoryID);
				buildResult10.setFkResAssId(Long.parseLong("1"));
				buildResult10.setResTarget("次要");
				buildResult10.setResTargetResult((float) result10);
				buildResult10.setResIgnore(0);
				buildResult10.setResRecorder(operaterName);
				buildResult10.setResOperateTime(t);
				buildResult10.setResCreateTime(t);
				buildResult10.setResTargetScore((float) 0);
				this.resultDao.save(buildResult10);

				// 信息
				double result11 = sd.getInfoCount(projectId);
				TEntExecuteResult buildResult11 = new TEntExecuteResult();
				buildResult11
						.setFkResInsId(Long.parseLong(projectId.toString()));
				buildResult11.setFkResExeId(exeHistoryID);
				buildResult11.setFkResAssId(Long.parseLong("1"));
				buildResult11.setResTarget("信息");
				buildResult11.setResTargetResult((float) result11);
				buildResult11.setResIgnore(0);
				buildResult11.setResRecorder(operaterName);
				buildResult11.setResOperateTime(t);
				buildResult11.setResCreateTime(t);
				buildResult11.setResTargetScore((float) 0);
				this.resultDao.save(buildResult11);

				this.saveBuildReportDescInfo(projectId, "BLOCKER",
						exeHistoryID, "阻断", operaterName);

				this.saveBuildReportDescInfo(projectId, "CRITICAL",
						exeHistoryID, "严重", operaterName);

				this.saveBuildReportDescInfo(projectId, "MAJOR", exeHistoryID,
						"主要", operaterName);
				this.saveBuildReportDescInfo(projectId, "MINOR", exeHistoryID,
						"次要", operaterName);
				this.saveBuildReportDescInfo(projectId, "INFO", exeHistoryID,
						"提示", operaterName);

			}
		}

	}

	/**
	 * 保存构建明细结果
	 * 
	 * @param projectId
	 * @param level
	 * @param exeHistoryID
	 * @param dimentName
	 * @param operaterName
	 */
	public void saveBuildReportDescInfo(Long projectId, String level,
			Long exeHistoryID, String dimentName, String operaterName) {

		SonarDao sd = new SonarDao();
		List<NormDesc> normList = sd.getNormDetail(projectId, level);
		JSONArray array = new JSONArray();
		for (NormDesc descObj : normList) {
			JSONObject obj = new JSONObject();
			obj.put("path", descObj.getPath());
			obj.put("lineNum", descObj.getLineNum());
			obj.put("message", descObj.getMessage());
			array.add(obj);
		}
		Timestamp t = new Timestamp(System.currentTimeMillis());
		TEntReportDesc desc = new TEntReportDesc();
		desc.setTEntExecuteSchemeId(projectId);
		desc.setInfoDesc(array.toString());
		desc.setTDicAssindexId(Long.valueOf(1));
		desc.setTDicAssindexName(dimentName);
		desc.setSubRecorder(operaterName);
		desc.setSubCreateTime(t);
		desc.setSubOperateTime(t);
		desc.setSubIgnore(0);
		desc.setTEntExeId(exeHistoryID);
		this.reportDescDao.save(desc);
	}
}
