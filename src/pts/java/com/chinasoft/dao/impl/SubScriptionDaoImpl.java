package com.chinasoft.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinasoft.dao.SubScriptionDao;
import com.chinasoft.dbservice.dao.impl.BaseDAOImpl;
import com.chinasoft.entities.MainInfo;


@Repository
public class SubScriptionDaoImpl extends BaseDAOImpl<MainInfo> implements SubScriptionDao
{

	@Override
	public Integer getMaxCI(Object[] param)
	{
		StringBuffer sqlClause = new StringBuffer();
//		sqlClause.append("SELECT DISTINCT sche.sch_ci_max");
//		sqlClause.append(" FROM t_pts_scheme sche,t_ent_inspection_scheme insp,t_ent_subscription sub");
//		sqlClause.append(" WHERE sche.pk_id=sub.fk_sub_sch_id AND sub.pk_id=insp.fk_ins_sub_id");
//		sqlClause.append(" AND (insp.ins_enterprise_tag=? AND insp.ins_enterprise_name=? AND insp.ins_project_tag=? AND insp.ins_project_name=? and insp.ins_ignore=0)");
		//根据企业标识 名称
		sqlClause.append("SELECT DISTINCT sche.sch_ci_max");
		sqlClause.append(" FROM t_pts_scheme sche,t_ent_subscription sub");
		sqlClause.append(" WHERE sche.pk_id = sub.fk_sub_sch_id");
		sqlClause.append("  AND (sub.sub_enterprise_tag = ? AND sub.sub_enterprise_name = ?)");
		Object [] params = new Object[2];
		params[0]=param[0];
		params[1]=param[1];
		return this.countForsql2(sqlClause.toString(), params);
	}

	@Override
	public BigInteger CI(Object[] param)
	{
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append("SELECT   COUNT(1)");
		sqlClause.append(" FROM t_ent_inspection_scheme insp");
		sqlClause.append(" WHERE ");
		sqlClause.append("(insp.ins_enterprise_tag=? AND insp.ins_enterprise_name=? AND insp.ins_project_tag=? AND insp.ins_project_name=? and insp.ins_ignore=0)");
		return this.countForSql(sqlClause.toString(), param);
	}

	@Override
	public List<MainInfo> getMainInfo(Object[] param)
	{
		
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append("SELECT  DISTINCT CAST(sche.sch_project_max AS CHAR) AS maxPro,CAST(sche.sch_ci_max AS CHAR) AS maxCi,CAST(sub.sub_project_num AS CHAR)AS proNum,sche.sch_name AS scheName,sche.sch_dimensions AS diment");
		sqlClause.append(" FROM t_pts_scheme sche,t_ent_inspection_scheme insp,t_ent_subscription sub");
		sqlClause.append(" WHERE sche.pk_id=sub.fk_sub_sch_id AND sub.pk_id=insp.fk_ins_sub_id ");
		sqlClause.append("AND (insp.ins_enterprise_tag=? AND insp.ins_enterprise_name=? AND insp.ins_project_tag=? AND insp.ins_project_name=?)");
		return this.exePrototypeSql(sqlClause.toString(), param, MainInfo.class);
	}
}
