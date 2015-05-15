package com.chinasoft.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.chinasoft.dao.InspectionDao;
import com.chinasoft.entities.InspectionScheme;
import com.chinasoft.service.InspectionService;
import com.chinasoft.util.HttpClientUtil;
import com.chinasoft.util.PropertiesUtil;

@Service("inspectionService")
public class InspectionServiceImpl implements InspectionService
{

	
	private static Logger logger = Logger.getLogger(InspectionServiceImpl.class);
//	@Autowired
//	private IBaseDAO<InspectionScheme> dao;
	
	@Resource
	private InspectionDao dao;
	
	
	@Override
	public List<InspectionScheme> findAll(Object [] param)
	{
		return dao.findAll(param);
	}//findAll
	
	@Override
	public void deleteObj(long id)
	{
		dao.deleteObj(id);
	}//deleteObj
	
	@Override
	public Serializable saveInspe(InspectionScheme sche)
	{
		return dao.saveInspe(sche);
	}//saveInspe
	@Override
	public InspectionScheme getInspect(long id)
	{
		return dao.getInspect(id);
	}//getInspect
	@Override
	public void updateInspe(InspectionScheme ins)
	{
		ins.setIns_create_time(new Timestamp(System.currentTimeMillis()));
		ins.setIns_operate_time(new Timestamp(System.currentTimeMillis()));
		dao.updateInspe(ins);
	}//updateInspe
	
	@Override
	public String updateServiceStatus(long id,int type) throws Exception
	{
		String ptsServiceHost=PropertiesUtil.readValue("PtsServiceHost");
		String ptsServiceSort=PropertiesUtil.readValue("PtsServiceSort");
		String ptsServiceWebName=PropertiesUtil.readValue("PtsServiceWebName");
		logger.info("ptsServiceHost++++++++:"+ptsServiceHost);
		logger.info("ptsServiceSort++++++++:"+ptsServiceSort);
		logger.info("PtsServiceWebName++++++++:"+ptsServiceWebName);
		
		String url="http://"+ptsServiceHost+":"+ptsServiceSort+"/"+ptsServiceWebName+"/reqEnableCiServlet?id="+id+"&type="+type;
		HttpClientUtil client=new HttpClientUtil(url, "");
		String result= client.callUrl();
		result=result.replace("\r\n", "");
		return result;
	}
	
	@Override
	public String promptlyBuild(long id) throws Exception {
		String ptsServiceHost=PropertiesUtil.readValue("PtsServiceHost");
		String ptsServiceSort=PropertiesUtil.readValue("PtsServiceSort");
		String ptsServiceWebName=PropertiesUtil.readValue("PtsServiceWebName");
		
		logger.info("ptsServiceHost++++++++:"+ptsServiceHost);
		logger.info("ptsServiceSort++++++++:"+ptsServiceSort);
		logger.info("PtsServiceWebName++++++++:"+ptsServiceWebName);
		
		String url="http://"+ptsServiceHost+":"+ptsServiceSort+"/"+ptsServiceWebName+"/reqExeCiServlet?id="+id;
		HttpClientUtil client=new HttpClientUtil(url, "");
		String result= client.callUrl();
		result=result.replace("\r\n", "");
		return result;
	}
	
	@Override
	public String addScheme(long id) throws Exception {
		String ptsServiceHost=PropertiesUtil.readValue("PtsServiceHost");
		String ptsServiceSort=PropertiesUtil.readValue("PtsServiceSort");
		String ptsServiceWebName=PropertiesUtil.readValue("PtsServiceWebName");
		
		logger.info("ptsServiceHost++++++++:"+ptsServiceHost);
		logger.info("ptsServiceSort++++++++:"+ptsServiceSort);
		logger.info("PtsServiceWebName++++++++:"+ptsServiceWebName);
		
		String url="http://"+ptsServiceHost+":"+ptsServiceSort+"/"+ptsServiceWebName+"/reqCreateCiServlet?id="+id;
		
		HttpClientUtil client=new HttpClientUtil(url, "");
		String result= client.callUrl();
		result=result.replace("\r\n", "");
		return result;
	}
	
	@Override
	public String deleteScheme(long id) throws Exception {
		String ptsServiceHost=PropertiesUtil.readValue("PtsServiceHost");
		String ptsServiceSort=PropertiesUtil.readValue("PtsServiceSort");
		String ptsServiceWebName=PropertiesUtil.readValue("PtsServiceWebName");
		
		logger.info("ptsServiceHost++++++++:"+ptsServiceHost);
		logger.info("ptsServiceSort++++++++:"+ptsServiceSort);
		logger.info("PtsServiceWebName++++++++:"+ptsServiceWebName);
		
		String url="http://"+ptsServiceHost+":"+ptsServiceSort+"/"+ptsServiceWebName+"/reqDelCiServlet?id="+id;
		HttpClientUtil client=new HttpClientUtil(url, "");
		String result= client.callUrl();
		result=result.replace("\r\n", "");
		return result;
	}
	
	@Override
	public String updateScheme(long id) throws Exception {
		String ptsServiceHost=PropertiesUtil.readValue("PtsServiceHost");
		String ptsServiceSort=PropertiesUtil.readValue("PtsServiceSort");
		String ptsServiceWebName=PropertiesUtil.readValue("PtsServiceWebName");
		
		logger.info("ptsServiceHost++++++++:"+ptsServiceHost);
		logger.info("ptsServiceSort++++++++:"+ptsServiceSort);
		logger.info("PtsServiceWebName++++++++:"+ptsServiceWebName);
		
		String url="http://"+ptsServiceHost+":"+ptsServiceSort+"/"+ptsServiceWebName+"/reqEditCiServlet?id="+id;
		HttpClientUtil client=new HttpClientUtil(url, "");
		String result= client.callUrl();
		result=result.replace("\r\n", "");
		return result;
	}

	@Override
	public Integer updateObj(long id,int status,int statType)
	{
		return dao.updateObj(id,status,statType);
	}
	
}
