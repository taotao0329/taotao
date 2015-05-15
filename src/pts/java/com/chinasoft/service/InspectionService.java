package com.chinasoft.service;

import java.io.Serializable;
import java.util.List;

import com.chinasoft.entities.InspectionScheme;

/**
 * BO
 * @author admin
 *
 */
public interface InspectionService
{
	/** 获取服务列表 */
	public List<InspectionScheme> findAll(Object [] param);
	/**删除记录*/
	public void deleteObj(long id);
	/** 新增记录*/
	public Serializable saveInspe(InspectionScheme sche);
	/** 根据ID获取记录 */
	public InspectionScheme getInspect(long id);
	/** 修改记录 */
	public void updateInspe(InspectionScheme ins);
	/**
	 * 根据服务方案ID变更服务方案启用停用状态
	 * @param id
	 * @throws Exception 
	 */
	public String updateServiceStatus(long id, int type) throws Exception;
	
	/**
	 *  立即构建
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public String promptlyBuild(long id) throws Exception;
	/**
	 * 新增方案调用接口
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String addScheme(long id) throws Exception;
	
	/**
	 * 删除方案
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteScheme(long id) throws Exception;
	/**
	 *  修改方案接口
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public  String updateScheme(long id) throws Exception;
	public Integer updateObj(long id,int status,int statType);
}
