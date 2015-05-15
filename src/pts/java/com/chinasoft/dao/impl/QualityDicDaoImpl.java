package com.chinasoft.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chinasoft.dao.QualityDicDao;
import com.chinasoft.dbservice.dao.impl.BaseDAOImpl;
import com.chinasoft.entities.QualityDic;

@Repository
public class QualityDicDaoImpl extends BaseDAOImpl<QualityDic> implements QualityDicDao
{

	@Override
	public List<QualityDic> getAllQualityDic(int key)
	{
		/**
		 * SELECT dic.ass_parent_target AS parentTag,dic.ass_child_target AS
		 * childTag,dic.ass_dimension_per AS dimPer,dic.ass_target_per AS
		 * tagPer,dic.ass_formula AS formula,dic.ass_unit AS unit FROM
		 * t_dic_assindex dic WHERE dic.ass_dimension_tag=1
		 */
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append("SELECT dic.ass_parent_target AS parentTag");
		sqlClause.append(" FROM  t_dic_assindex dic WHERE dic.ass_dimension_tag=?");
		sqlClause.append(" GROUP BY dic.ass_parent_target");
		return this.exePrototypeSql(sqlClause.toString(), new Object[]{key}, QualityDic.class);
	}

	@Override
	public Map<Integer,String> getQualityDic()
	{
		/**
		 * 
		 */
		Map<Integer,String> result = new HashMap<Integer, String>();
		List<QualityDic> dicList = null;
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append("SELECT dic.ass_dimension_tag AS tag,dic.ass_dimension AS dimension");
		sqlClause.append(" FROM t_dic_assindex dic");
		sqlClause.append(" GROUP BY dic.ass_dimension_tag,dic.ass_dimension");
		dicList = this.exePrototypeSql(sqlClause.toString(), null, QualityDic.class);
		for(QualityDic dic :dicList)
		{
			result.put(dic.getTag(), dic.getDimension());
		}
		return result;
	}

	@Override
	public List<QualityDic> getAllQualityDic(String key)
	{
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append("SELECT  dic.ass_parent_target AS parentTag,dic.ass_child_target AS childTag,CAST(dic.ass_dimension_per AS CHAR) AS dimPer,CAST(dic.ass_target_per AS CHAR) AS tagPer,");
		sqlClause.append("dic.ass_formula AS formula,dic.ass_unit AS unit");
		sqlClause.append(" FROM t_dic_assindex dic WHERE dic.ass_parent_target=?");
		return this.exePrototypeSql(sqlClause.toString(), new Object[]{key}, QualityDic.class);
	}
	
}
