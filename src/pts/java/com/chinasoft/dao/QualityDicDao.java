package com.chinasoft.dao;

import java.util.List;
import java.util.Map;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.QualityDic;

public interface QualityDicDao extends IBaseDAO<QualityDic>
{
	/**查询某个维度下的父类指标权重 */
	public List<QualityDic> getAllQualityDic(int key);
	/**查询某个维度下的父类指标下的子类指标权重 */
	public List<QualityDic> getAllQualityDic(String key);
	/**单个对象 */
	public Map<Integer,String> getQualityDic();
}
