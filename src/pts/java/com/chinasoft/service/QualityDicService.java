package com.chinasoft.service;

import java.util.List;
import java.util.Map;

import com.chinasoft.entities.QualityDic;

public interface QualityDicService
{
	/**查询某个维度下父类指标权重 */
	public List<QualityDic> getAllQualityDic(int key);
	/**查询某个维度下父类指标下的子类权重 */
	public List<QualityDic> getAllQualityDic(String key);
	/**单个对象 */
	public Map<Integer,String> getQualityDic();
}
