package com.chinasoft.action;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chinasoft.common.tools.OperationException;
import com.chinasoft.entities.MainInfo;
import com.chinasoft.entities.NoticeSys;
import com.chinasoft.entities.PtsScheme;
import com.chinasoft.service.IPermissService;
import com.chinasoft.service.ISubScription;
import com.chinasoft.service.NoticeSysService;
import com.chinasoft.service.PtsSchemeService;
import com.chinasoft.service.QualityDicService;
import com.chinasoft.util.BaseAction;
import com.opensymphony.xwork2.ActionSupport;

@Controller("dispatcherAction")
@Scope("prototype")
/**
 * 判断跳转的主action
 * 提供给JF的action
 * @author admin
 *
 */
public class DispatcherAction extends BaseAction
{
	private static final Logger logger = Logger.getLogger(DispatcherAction.class);
	
	private String proName;
	
	private String orgName;
	
	@Autowired
	private IPermissService permiss;
	
	@Autowired
	private ISubScription subIon;
	
	@Autowired
	private NoticeSysService notice;
	
	@Autowired
	private QualityDicService dic;
	
	@Autowired
	private PtsSchemeService pts;
	
	/** 权限结果 */
	private int resu;

	private List<MainInfo>	mainInfo;
	
	private List<NoticeSys> notices;
	
	private List<PtsScheme> ptsList;

	private int	isCi;
	
	private int maxCiPortal;
	
	public String init()
	{
		/**
		 * SSO接口传递信息如下：
		 * 	1.企业名称
		 *  2.企业唯一标识
		 *  3.项目名称
		 *  4.项目唯一标识
		 *  5.登陆用户唯一标识
		 *  6.登陆用户名
		 *  7.用户姓名
		 *  8.用户类型（PM、项目成员）
		 */
		//2.通过登陆用户名、项目标识，查询该人员是否在该项目的权限表内，有：“服务执行”被激活；否：“服务执行”置灰； 
		logger.debug("test & test"+proName+orgName);
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession sess = req.getSession();
		//企业名称
		sess.setAttribute("enterpriseName", "chinasoft");
		//企业唯一标识
		sess.setAttribute("enterpriseCode", "10010");
		//项目名称
		sess.setAttribute("proName", "JF-pts_dbservice");
		//项目标识
		sess.setAttribute("proCode", "8888888888888888");
		//当前登陆用户
		sess.setAttribute("userName", "admin");
		//用户类型{0:PM 1:项目成员}
		sess.setAttribute("userType", 0);
		Object [] param = {"admin","admin","10010","chinasoft","JF-pts_dbservice","8888888888888888"};
		//查询权限
		BigInteger  result = permiss.validateJF(param);
		resu = result.intValue();
		sess.setAttribute("resu", resu);
		//最大CI个数
		Integer maxCI = subIon.getMaxCI(new Object[]{sess.getAttribute("enterpriseCode"),sess.getAttribute("enterpriseName"),sess.getAttribute("proCode"),sess.getAttribute("proName")});
		if(null == maxCI)
		{
			maxCI = new Integer(0);
		}
		maxCiPortal = maxCI.intValue();
		isCi = 0;
		//已有CI个数
		BigInteger ci = subIon.CI(new Object[] { sess.getAttribute("enterpriseCode"),
				sess.getAttribute("enterpriseName"), sess.getAttribute("proCode"),
				sess.getAttribute("proName") });
		String sign = "0";
		if(null == ci)
		{
			ci  = new BigInteger("0");
		}
		isCi = ci.intValue();
		if (ci.intValue() >= maxCI.intValue())
		{
			sign = "1";
		}
		sess.setAttribute("sign", sign);
		//首页信息概要
		mainInfo = subIon.getMainInfo(new Object[]{sess.getAttribute("enterpriseCode"),sess.getAttribute("enterpriseName"),sess.getAttribute("proCode"),sess.getAttribute("proName")});
		logger.debug(mainInfo);
		//系统公告
		notices = notice.get();
		//字典结果
		Map<Integer, String> qualityDic = dic.getQualityDic();
		//方案集合
		ptsList = pts.getAllPtsScheme();
		//检查参数
		if(null == ptsList || ptsList.size()==0 || qualityDic.size()==0)
		{
			return "disp";
		}
		translateDimName(qualityDic);
		return "disp";
	}//get
	private void translateDimName(Map<Integer, String> qualityDic)
	{
		//数组容器
		PtsScheme [] ps = new PtsScheme[ptsList.size()];
		//填充数组
		ps = ptsList.toArray(ps);
		//接收转后之后的维度信息
		StringBuffer translate = null;
		//遍历数组
		for(PtsScheme p :ps)
		{
			//维度信息
			String dims = p.getSch_dimensions();
			//初始化buffer
			translate = new StringBuffer();
			//遍历维度信息
			if (dims.contains(","))
			{
				for (String s : dims.split(","))
				{
					// 字典中包含方案中的维度信息
					if (qualityDic.containsKey(Integer.parseInt(s)))
					{
						// 翻译
						String value = qualityDic.get(Integer.parseInt(s));
						translate.append(value).append(" ");
					}
				}
			}else
			{
				if (qualityDic.containsKey(Integer.parseInt(dims)))
				{
					// 翻译
					String value = qualityDic.get(Integer.parseInt(dims));
					translate.append(value).append(" ");
				}
			}
			//设置维度信息
			p.setSch_dimensions(translate.toString());
		}
		//转换容器
		ptsList = Arrays.asList(ps);
	}//translateDimName
	public String getProName()
	{
		return proName;
	}
	public void setProName(String proName)
	{
		this.proName = proName;
	}
	public String getOrgName()
	{
		return orgName;
	}
	public void setOrgName(String orgName)
	{
		this.orgName = orgName;
	}
	public int getResu()
	{
		return resu;
	}
	public void setResu(int resu)
	{
		this.resu = resu;
	}
	public List<MainInfo> getMainInfo()
	{
		return mainInfo;
	}
	public void setMainInfo(List<MainInfo> mainInfo)
	{
		this.mainInfo = mainInfo;
	}
	public int getIsCi()
	{
		return isCi;
	}
	public void setIsCi(int isCi)
	{
		this.isCi = isCi;
	}
	public List<NoticeSys> getNotices()
	{
		return notices;
	}
	public void setNotices(List<NoticeSys> notices)
	{
		this.notices = notices;
	}
	public int getMaxCiPortal()
	{
		return maxCiPortal;
	}
	public void setMaxCiPortal(int maxCiPortal)
	{
		this.maxCiPortal = maxCiPortal;
	}
	public List<PtsScheme> getPtsList()
	{
		return ptsList;
	}
	public void setPtsList(List<PtsScheme> ptsList)
	{
		this.ptsList = ptsList;
	}
	
	
	
	
}
