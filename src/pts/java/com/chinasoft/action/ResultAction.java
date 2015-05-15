package com.chinasoft.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chinasoft.common.tools.OperationException;
import com.chinasoft.entities.CompileDesc;
import com.chinasoft.entities.ExeResuEnti;
import com.chinasoft.entities.HistoryRecord;
import com.chinasoft.entities.InspectionScheme;
import com.chinasoft.entities.QualityDic;
import com.chinasoft.entities.ResultExeInsp;
import com.chinasoft.service.ExeResuEntiService;
import com.chinasoft.service.HistoryRecordService;
import com.chinasoft.service.IExecuteSchemeService;
import com.chinasoft.service.InspectionService;
import com.chinasoft.service.QualityDicService;
import com.chinasoft.util.BaseAction;
import com.opensymphony.xwork2.Action;

@Controller("resultAct")
@Scope("prototype")
public class ResultAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6761951792843189496L;

	// logger
	private static final Logger log = Logger.getLogger(ResultAction.class);

	// 作用于结果集
	private List<ResultExeInsp> list3;

	/** 企业项目健康检查方案标识 */
	private long code;

	/** 自身标示 */
	private long id;

	/** 构建历史 */
	private List<HistoryRecord> historyRecord;

	private List<CompileDesc> compHistory;

	// Assembly bean
	@Autowired
	private IExecuteSchemeService exeService;
	// assembly bean
	@Autowired
	private InspectionService inspService;

	@Autowired
	private HistoryRecordService historyService;
	
	@Autowired
	private QualityDicService dic;
	@Autowired
	private ExeResuEntiService exe;
	
	/**key 超类标识
	 * Map 容器
	 * key 父类标识
	 * value 子类标识
	 */
	private Map<String,Map<String,List<QualityDic>>>	result;

	//计算总分数
	private int	score;
	
	private StringBuffer superDims;
	
	private String callBackDims;

	/**
	 * 立即构建
	 * 
	 * @return
	 */
	public String createBuild() {
		log.debug("start createBuild... and param{'" + code + "'}");
		// TODO 不新增记录 直接通知ptsservice参数CI方案的ID
		exeService.saveBuild(code);
		log.debug("end createBuild...");
		return "ok";
	}// createBuild

	/**
	 * 编辑
	 * 
	 * @return
	 */
	public String updateBuild() {
		log.debug("start updateBuild... and param{'" + id + "'}");
		exeService.updateBuild(id);
		log.debug("end updateBuild...");
		return "ok";
	}// updateBuild

	/**
	 * 获取列表
	 * 
	 * @return
	 */
	public String getObj() {
		list3 = exeService.get(code);
		log.debug("start getObj...and resu:【'" + list3 + "'】");
		return Action.SUCCESS;
	}// getObj

	public String getCompDesc() 
	{
		
		// 1.获取该CI方案的服务维度
		InspectionScheme insp = inspService.getInspect(code);
		if (null == insp)
		{
			throw new OperationException("search CI scheme is null");
		}
		BigDecimal _score = BigDecimal.ZERO;
		String ins_check_diment = insp.getIns_check_diment();
		superDims = new StringBuffer();
		// 获取字典结果
		Map<Integer, String> qualityDic = dic.getQualityDic();
		if (qualityDic.isEmpty())
		{
			throw new OperationException("the Dic is null");
		}
		result = new HashMap<String, Map<String, List<QualityDic>>>();

		// 多个维度
		if (ins_check_diment.contains(","))
		{
			// 遍历维度
			for (String s : ins_check_diment.split(","))
			{
				// 容器 一个父类指标映射一组子类指标
				Map<String, List<QualityDic>> datas = new HashMap<String, List<QualityDic>>();
				// 超类指标
				String val = null;
				if (qualityDic.containsKey(Integer.parseInt(s)))
				{
					// 获取
					val = qualityDic.get(Integer.parseInt(s));
					superDims.append(s+":");
				}
				// 根据超类指标获取父类指标
				List<QualityDic> allQualityDic = dic.getAllQualityDic(Integer.parseInt(s));
				if (null != allQualityDic && allQualityDic.size() > 0)
				{
					for (QualityDic q : allQualityDic)
					{
						String parentTag = q.getParentTag();
						// 根据大类指标获得子类指标
						List<QualityDic> child = dic.getAllQualityDic(parentTag);
						for (QualityDic chi : child)
						{
							// 计算得分情况
							ExeResuEnti exeResu = exe.getExeResu(code, id, chi.getChildTag());
							chi.setScore(exeResu != null ? exeResu.getScore() : "0");
							//计算最后得分
							_score = _score.add(new BigDecimal(chi.getScore())).setScale(0, BigDecimal.ROUND_HALF_UP);
							log.debug(exeResu);
						}
						// set到容器
						datas.put(parentTag, child);
					}
				}
				result.put(val, datas);
			}
		}
		else
		// 单个维度
		{
			Map<String, List<QualityDic>> datas = new HashMap<String, List<QualityDic>>();
			String val = null;
			if (qualityDic.containsKey(Integer.parseInt(ins_check_diment)))
			{
				// 超类指标
				val = qualityDic.get(Integer.parseInt(ins_check_diment));
				superDims.append(ins_check_diment+":");
			}
			List<QualityDic> allQualityDic = dic.getAllQualityDic(Integer.parseInt(ins_check_diment));
			if (null != allQualityDic && allQualityDic.size() > 0)
			{
				for (QualityDic q : allQualityDic)
				{
					String parentTag = q.getParentTag();
					// 根据大类指标获得子类指标
					List<QualityDic> child = dic.getAllQualityDic(parentTag);
					for (QualityDic chi : child)
					{
						// 计算得分情况
						ExeResuEnti exeResu = exe.getExeResu(code, id, chi.getChildTag());
						chi.setScore(exeResu != null ? exeResu.getScore() : "0");
						//计算最后得分
						_score = _score.add(new BigDecimal(chi.getScore())).setScale(0, BigDecimal.ROUND_HALF_UP);
						log.debug(exeResu);
					}
					// set到容器
					datas.put(parentTag, child);
				}
			}
			result.put(val, datas);
		}
		score = _score.intValue();
		log.debug(">>>>>>"+score);
		/** 某个CI方案的某次构建结果 */
		log.debug(id + "" + code);
		compHistory = exeService.getCompileDesc(id, code);
		return "compDesc";
	}
	/**
	 * 获取饼图数据
	 * @return
	 */
	public String getDatas()
	{
		log.debug("call Param>>>>>>>"+callBackDims);
		// 获取字典结果
		Map<Integer, String> qualityDic = dic.getQualityDic();
		if (qualityDic.isEmpty())
		{
			throw new OperationException("the Dic is null");
		}
		//获取哪些维度参与了显示
		String [] arr = callBackDims.split(":");
		//数据集合 
		StringBuffer context_ = new StringBuffer();
		context_.append("{param:[");
		//遍历维度
		for(String s:arr)
		{
			//颜色
			String color = s.equals("1") ? "#e77b01" : s.equals("2") ? "#4fa900" : s.equals("3") ? "#0488cd" :"#d77089";
			//所占比例
			float y = s.equals("1") ? 1.2f : s.equals("2") ? 2.5f : s.equals("3") ? 3.4f :1.4f;
			context_.append("{name:'"+qualityDic.get(Integer.parseInt(s))+"',color:'"+color+"',y:"+y+"}");
			if(arr.length!=1 && s!=arr[arr.length-1])
			{
				context_.append(",");
			}
		}
		context_.append("]}");
//		String context="{param:[{name : '可维护',color : '#e77b01',y : 115}, {name : '可靠',color : '#4fa900',y : 25}, {name : '规范',color : '#0488cd',y : 10}, {name : '编译',color : '#d77089',y : 14}]}";
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(context_.toString());
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getOthers()
	{
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("row", 100);
		map.put("package_", 200);
		map.put("file", 300);
		map.put("class_", 400);
		map.put("function_", 500);
		map.put("zhushi", 600);
		JSONObject fromObject = JSONObject.fromObject(map);
		log.debug(fromObject.toString());
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(fromObject.toString());
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 历史构建信息
	 * 
	 * @return
	 */
	public String getBuildHistory() {
		// compHistory = exeService.getCompileDesc();
		historyRecord = historyService.getHistory(code);
		if (null != historyRecord && historyRecord.size() > 0) {
			HistoryRecord[] his = new HistoryRecord[historyRecord.size()];
			his = historyRecord.toArray(his);
			for (int i = 0; i < his.length; i++) {
				his[i].setOdds(his[i].getOdds() + "%");
			}
			historyRecord = Arrays.asList(his);
		}
		log.debug("start getBuildHistory...");
		return "history";
	}// getBuildHistory

	public String promptlyBuild() {

		log.debug("start build...");
		String result = "false";
		try {
			result = this.inspService.promptlyBuild(id);

			if (result.equals("ok")) {
				// 构建执行成功，获取sonar执行结果

				String loginName = (String) this.getSession("username");
				exeService.saveBuildCheckInfo(id, loginName);
			}

		} catch (Exception e) {
			// 这里才能得到异常信息
			e.printStackTrace();
			log.error("build exception:" + e.getMessage());
			result = "false";
		}

		return this.ajaxJsonSuccessMessage(result);

	}

	public long getCode() {
		return code;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public List<ResultExeInsp> getList3() {
		return list3;
	}

	public void setList3(List<ResultExeInsp> list3) {
		this.list3 = list3;
	}

	public List<CompileDesc> getCompHistory() {
		return compHistory;
	}

	public void setCompHistory(List<CompileDesc> compHistory) {
		this.compHistory = compHistory;
	}

	public List<HistoryRecord> getHistoryRecord() {
		return historyRecord;
	}

	public void setHistoryRecord(List<HistoryRecord> historyRecord) {
		this.historyRecord = historyRecord;
	}
	public Map<String, Map<String, List<QualityDic>>> getResult()
	{
		return result;
	}

	public void setResult(Map<String, Map<String, List<QualityDic>>> result)
	{
		this.result = result;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public StringBuffer getSuperDims()
	{
		return superDims;
	}

	public void setSuperDims(StringBuffer superDims)
	{
		this.superDims = superDims;
	}

	public String getCallBackDims()
	{
		return callBackDims;
	}

	public void setCallBackDims(String callBackDims)
	{
		this.callBackDims = callBackDims;
	}

	
	
	
	// public ExecuteScheme getScheme()
	// {
	// return scheme;
	// }
	// public void setScheme(ExecuteScheme scheme)
	// {
	// this.scheme = scheme;
	// }

}
