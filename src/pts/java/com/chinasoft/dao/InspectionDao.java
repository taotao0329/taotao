package com.chinasoft.dao;

import java.io.Serializable;
import java.util.List;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.InspectionScheme;

public interface InspectionDao extends IBaseDAO<InspectionScheme> 
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
	public void updateServiceStatus(long id);
	
	public Integer updateObj(long id,int status,int statType);
}
