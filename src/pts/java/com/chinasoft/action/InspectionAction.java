package com.chinasoft.action;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chinasoft.entities.InspectionScheme;
import com.chinasoft.entities.Schemesub;
import com.chinasoft.service.ISubScription;
import com.chinasoft.service.InspectionService;
import com.chinasoft.service.QualityDicService;
import com.chinasoft.service.SchemesubService;
import com.chinasoft.util.BaseAction;
import com.opensymphony.xwork2.Action;

@Controller("inspectionAction")
@Scope("prototype")
public class InspectionAction extends BaseAction
{
	
	private static final Logger logger = Logger.getLogger(InspectionAction.class);
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -3346395231166971462L;

	@Autowired
	private InspectionService inspectionService;
	@Autowired
	private ISubScription subIon;
	@Autowired
	private SchemesubService scheme;
	@Autowired
	private QualityDicService dic;
	/** VO */
	private InspectionScheme sche;
	/** 结果集 */
	private List<InspectionScheme> list;
	
	/** 超链接操作 参数 */
	private long id;
	
	/** 构建时间 */
	private String beginTime1;
	private String beginTime2;
	/** 仓库 */
	private Map<String,String> storage;
	/**分支 */
	private Map<String,String> branch;
	
	/**　检查维度 */
	private Map<String,String> diment;
	
	/** checkBox 列表 */
	private String [] diments;
	
	private String branchName;
	
	private String sign;
	/**
	 * 启用停用状态
	 */
	private Integer typeStatus;
	
	
	private String isOk;
	private String url;
	private String	format;
	
	
	
	public String getBranch2() throws IOException
	{
		logger.debug(""+id);
		/*branch = new LinkedHashMap<String, String>();
		branch.put("Master1", "Master1");
		branch.put("Master2", "Master2");
		branch.put("Master3", "Master3");
		branch.put("Master4", "Master4");
		branch.put("Master5", "Master5");
		branch.put("Master6", "Master6");
		branch.put("Master7", "Master7");*/
//		result = "1:Master1:2:Master2:3:Master3";  
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html");
		StringBuffer branch = new StringBuffer();
		if(id==1)
		{
			//GIT仓库1
			branch.append(" <option value='master'>").append("master").append("</option>");
			branch.append(" <option value='1'>").append("Master1").append("</option>");
			branch.append(" <option value='2'>").append("Master2").append("</option>");
			branch.append(" <option value='3'>").append("Master3").append("</option>");
			branch.append(" <option value='4'>").append("Master4").append("</option>");
			
		}else if(id==2)
		{
			//GIT仓库2
			branch.append(" <option value='5'>").append("Test1").append("</option>");
			branch.append(" <option value='6'>").append("Test2").append("</option>");
			branch.append(" <option value='7'>").append("Test3").append("</option>");
			branch.append(" <option value='8'>").append("Test4").append("</option>");
		}else
		{
			branch.append(" <option value='-1'>").append("----请选择---").append("</option>");
		}
		
		resp.getWriter().write(branch.toString());
		return null;
	}
	/**
	 * 服务设置列表查询
	 * @return
	 */
	public String findAll()
	{
		logger.debug("start search all...");
		//TODO 获取是够能新建方案
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
//		String proName = (String)session.getAttribute("proName");
		 
		/**
		 * 1.首先查询该已经拥有的方案个数
		 * 2.查询配置的方案个数
		 */
		Integer maxCI = subIon.getMaxCI(new Object[]{session.getAttribute("enterpriseCode"),session.getAttribute("enterpriseName"),session.getAttribute("proCode"),session.getAttribute("proName")});
		//已经配置的CI个数
		BigInteger ci = subIon.CI(new Object[]{session.getAttribute("enterpriseCode"),session.getAttribute("enterpriseName"),session.getAttribute("proCode"),session.getAttribute("proName")});
		if(ci.intValue()>=maxCI.intValue())
		{
			sign="1";
		}else
		{
			sign="0";
		}
		session.setAttribute("sign", sign);
		//直接查询
		list = inspectionService.findAll(new Object[]{session.getAttribute("enterpriseCode"),session.getAttribute("enterpriseName"),session.getAttribute("proCode"),session.getAttribute("proName")});
		//TODO 这里后面从JF平台过来项目名称
		if(null !=list && list.size()>1)
		sche = list.get(0);
		logger.debug("end search all...&result:['"+list+"']");
		return Action.SUCCESS;
	}//findAll
	
	/**
	 * 删除
	 * @return
	 */
	public String deleteInspec()
	{
		logger.debug("start delete obj...&code="+id);
		//变更状态
		inspectionService.updateObj(id,1,-1);
		logger.debug("end delete obj...");
		
		//调用接口
		String result="false";
		try {
			result=this.inspectionService.deleteScheme(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug("invoke ciservice result:"+result);
		/*if(result.equals("ok")){
			return "ok";
		}
		else{
			return "failed";
		}*/
		isOk = "成功";
		url = "/inspection/inspection_findAll.action";
		if(!result.equalsIgnoreCase("ok"))
		{
			//调用接口失败调整
			inspectionService.updateObj(id,0,-1);
			isOk = "失败";
			logger.debug("invoke ciservice failed...");
		}
		return "commonPage";
		
		
	}//deleteInspec
	
	/**
	 * 创建前 首先加载下拉框数据
	 * @return
	 */
	public String loadAttr()
	{
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		Schemesub enty = scheme.getSchemesub((String)session.getAttribute("enterpriseCode"), (String)session.getAttribute("enterpriseName"));
		logger.debug(enty);
		/** 企业订购方案的检查维度 */
		String scheDiments = enty.getScheDiments();
		//字典结果
		Map<Integer, String> qualityDic = dic.getQualityDic();
		//维度信息 来源于该企业购买的服务
		diment = new HashMap<String, String>();
		if (scheDiments.contains(","))
		{
			for (String s : scheDiments.split(","))
			{
				if (qualityDic.containsKey(Integer.parseInt(s)))
				{
					diment.put(s, qualityDic.get(Integer.parseInt(s)));
				}
			}
		}else
		{
			if (qualityDic.containsKey(Integer.parseInt(scheDiments)))
			{
				diment.put(scheDiments, qualityDic.get(Integer.parseInt(scheDiments)));
			}
		}
		/**构造的数据 */
		storage = new HashMap<String, String>();
		storage.put("1", "GIT仓库1");
		storage.put("2", "GIT仓库2");
		/*branch = new LinkedHashMap<String, String>();
		branch.put("Master1", "Master1");
		branch.put("Master2", "Master2");
		branch.put("Master3", "Master3");
		branch.put("Master4", "Master4");
		branch.put("Master5", "Master5");
		branch.put("Master6", "Master6");
		branch.put("Master7", "Master7");*/
		
//		diment.put("1","规范");
//		diment.put("2","可维护 ");
//		diment.put("3","可靠");
//		diment.put("4","编译 ");
		return "Attr";
	}//loadAttr
	
	/**
	 * 保存
	 * @return
	 */
	public String saveInspe()
	{
		logger.debug("beginTime1 :"+beginTime1+"beginTime2"+beginTime2);
		/** 获取执行类型 */
		if(sche.getIns_build_type()!=1)
		{
			//定时执行
			
			if(sche.getIns_time_build_type()==0)
			{
				//单次
				sche.setIns_time_build_time(Timestamp.valueOf(beginTime1));
			}else
			{
				//循环
				sche.setIns_exetime(beginTime2);
			}
			
		}
		StringBuffer checkDiemnt = new StringBuffer();
		/** 获取复选框结果 */
		if(null !=diments && diments.length>0)
		{
			for (String s : diments)
			{
				checkDiemnt.append(s).append(",");
			}
			sche.setIns_check_diment(checkDiemnt.toString().substring(0, checkDiemnt.toString().length() - 1));
		}
		HttpSession sess = ServletActionContext.getRequest().getSession();
//		sche.setFk_ins_ser_ip("255.255.255.255");
		sche.setIns_accredit("pts");
		//企业名称
		sche.setIns_enterprise_name((String)sess.getAttribute("enterpriseName"));
		//企业标识
		sche.setIns_enterprise_tag((String)sess.getAttribute("enterpriseCode"));
		//项目名称
		sche.setIns_project_name((String)sess.getAttribute("proName"));
		//项目标识
		sche.setIns_project_tag((String)sess.getAttribute("proCode"));
		//订购标识
		sche.setFk_ins_sub_id(2);
//		sche.setIns_gitlab_url("localhost:8080/pts");
		sche.setIns_create_time(new Timestamp(System.currentTimeMillis()));
		sche.setIns_operate_time(new Timestamp(System.currentTimeMillis()));
		sche.setIns_gitlab_url("https://github.com/ChinasoftMan/AntProject2.git");
		sche.setFk_ins_ser_ip("127.0.0.1");
		//当做成功处理 
		sche.setIns_ignore(0);
		long code = (long)inspectionService.saveInspe(sche);
		
		//调用接口
		String result="false";
		try {
			result=this.inspectionService.addScheme(code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		result=result.replace("\r\n", "");
		logger.debug("invoke cisevice result:"+result);
		/*if(code>0&&result.equals("ok"))
			return "ok";
		else
			return "failed";*/
		isOk = "成功";
		url = "/inspection/inspection_findAll.action";
		if(!result.equalsIgnoreCase("ok"))
		{
			//调用接口失败调整
			inspectionService.updateObj(code,1,-1);
			isOk = "失败";
			url = "/inspection/inspection_loadAttr.action";
			logger.debug("invoke cisevice failed");
		}
		return "commonPage";
	}//saveInspe
	
	/**
	 * 更新对象
	 * @return
	 */
	public String updateInspe()
	{
		InspectionScheme old = (InspectionScheme)this.getSession("oldSche");
		/** 获取执行类型 */
		if(sche.getIns_build_type()!=1)
		{
			//定时执行
			
			if(sche.getIns_time_build_type()==0)
			{
				//单次
				sche.setIns_time_build_time(Timestamp.valueOf(beginTime1));
			}else
			{
				//循环
				sche.setIns_exetime(beginTime2);
			}
			
		}
		StringBuffer checkDiemnt = new StringBuffer();
		if(null !=diments && diments.length>0)
		{
			for (String s : diments)
			{
				checkDiemnt.append(s).append(",");
			}
			sche.setIns_check_diment(checkDiemnt.toString().substring(0, checkDiemnt.toString().length() - 1));
		}
		sche.setIns_operate_time(new Timestamp(System.currentTimeMillis()));
		inspectionService.updateInspe(sche);
		
		//调用接口
		String result="false";
		try {
			result=this.inspectionService.updateScheme(sche.getPk_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		result=result.replace("\r\n", "");
		/*if(sche.getPk_id()>0&&result.equals("ok"))
			return "ok";
		else
			return "failed";*/
		logger.debug("invoke cisevice result:"+result);
		if(!result.equalsIgnoreCase("ok"))
		{
			//调用接口失败调整
			inspectionService.updateInspe(old);
			isOk = "失败";
			logger.debug("invoke cisevice failed");
		}else
		{
			isOk = "成功";
			this.getSession().remove("oldSche");
		}
		url = "/inspection/inspection_findAll.action";
		return "commonPage";
	}//updateInspe
	
	/**
	 * get对象为修改准备
	 * @return
	 */
	public String getInspect()
	{
		storage = new HashMap<String, String>();
		storage.put("1", "GIT仓库1");
		storage.put("2", "GIT仓库2");
		logger.debug(branchName);
		branch = new LinkedHashMap<String, String>();
		if(branchName.equals("1"))
		{
			branch.put("master", "master");
			branch.put("1", "Master1");
			branch.put("2", "Master2");
			branch.put("3", "Master3");
			branch.put("4", "Master4");
		}else if(branchName.equals("2"))
		{
			branch.put("5", "Test1");
			branch.put("6", "Test2");
			branch.put("7", "Test3");
			branch.put("8", "Test4");
		}
		diment = new HashMap<String, String>();
		diment.put("1","规范");
		diment.put("2","可维护 ");
		diment.put("3","可靠");
		diment.put("4","编译 ");
		sche = inspectionService.getInspect(id);
		/** 转换的目的 为了去除 毫秒 */
		Timestamp ins_time_build_time = sche.getIns_time_build_time();
		if(null != ins_time_build_time)
		format = sdf.format(ins_time_build_time);

		//记录old对象
		this.setSession("oldSche", sche);
		return "get";
	}//getInspect
	public String init()
	{
		System.out.println(id);
		return "success";
	}
	
	/**
	 * 启动服务设置方案
	 * @return
	 */
	public String startService()
	{
		// 数据库启动
		logger.debug("start startService...");
		int tmp = -1;
		if (typeStatus == 0)
		{
			tmp = 1;
		}
		else if (typeStatus == 1)
		{
			tmp = 0;
		}
		logger.debug("start DB update and param{'id:''" + id + "','typeStatus''" + typeStatus + "'}...");
		inspectionService.updateObj(id, -1, typeStatus);
		logger.debug("start DB update End");
		String result = "false";
		try
		{
			logger.debug("start startService invoke interface...");
			result = this.inspectionService.updateServiceStatus(id, typeStatus);
			result = result.replace("\r\n", "");
			logger.debug("start startService invoke interface end and result:'"+result+"'...");
		}
		catch (Exception e)
		{
			//处理异常
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug("invoke cisevice result:" + result);
		if (!result.equalsIgnoreCase("ok"))
		{
			// 调用接口失败
			inspectionService.updateObj(id, -1, tmp);
			logger.debug("invoke cisevice failed...");
		}
		return this.ajaxJsonSuccessMessage(result);
	}
	
	
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public InspectionScheme getSche()
	{
		return sche;
	}
	public void setSche(InspectionScheme sche)
	{
		this.sche = sche;
	}
	public List<InspectionScheme> getList()
	{
		return list;
	}
	public void setList(List<InspectionScheme> list)
	{
		this.list = list;
	}

	public String getBeginTime1()
	{
		return beginTime1;
	}

	public void setBeginTime1(String beginTime1)
	{
		this.beginTime1 = beginTime1;
	}

	public String getBeginTime2()
	{
		return beginTime2;
	}

	public void setBeginTime2(String beginTime2)
	{
		this.beginTime2 = beginTime2;
	}

	public Map<String, String> getStorage()
	{
		return storage;
	}

	public void setStorage(Map<String, String> storage)
	{
		this.storage = storage;
	}

	public Map<String, String> getBranch()
	{
		return branch;
	}

	public void setBranch(Map<String, String> branch)
	{
		this.branch = branch;
	}

	public Map<String, String> getDiment()
	{
		return diment;
	}

	public void setDiment(Map<String, String> diment)
	{
		this.diment = diment;
	}

	public String[] getDiments()
	{
		return diments;
	}

	public void setDiments(String[] diments)
	{
		this.diments = diments;
	}
	public String getBranchName()
	{
		return branchName;
	}
	public void setBranchName(String branchName)
	{
		this.branchName = branchName;
	}
	public String getSign()
	{
		return sign;
	}
	public void setSign(String sign)
	{
		this.sign = sign;
	}
	public Integer getTypeStatus() {
		return typeStatus;
	}
	public void setTypeStatus(Integer typeStatus) {
		this.typeStatus = typeStatus;
	}
	public String getIsOk()
	{
		return isOk;
	}
	public void setIsOk(String isOk)
	{
		this.isOk = isOk;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getFormat()
	{
		return format;
	}
	public void setFormat(String format)
	{
		this.format = format;
	}
	

	
	
}
