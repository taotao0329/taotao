package com.chinasoft.dao.impl;


import org.springframework.stereotype.Repository;

import com.chinasoft.dao.SchemesubDao;
import com.chinasoft.dbservice.dao.impl.BaseDAOImpl;
import com.chinasoft.entities.Schemesub;

@Repository
public class SchemesubDaoImpl extends BaseDAOImpl<Schemesub> implements SchemesubDao
{

	@Override
	public Schemesub getSchemesub(String enterpriseTag, String enterpriseName)
	{
		/**
		 * -- 查询当前企业订购的方案 SELECT sche.pk_id AS scheCode,sche.sch_name AS
		 * scheName,sche.sch_type AS scheType,sche.sch_project_max AS
		 * scheMaxProject,sche.sch_ci_max AS scheMaxCi, sche.sch_date_area AS
		 * scheServiceVali,sche.sch_dimensions AS scheDiments, sub.pk_id AS
		 * subCode,sub.sub_email AS subEmail,sub.sub_contact AS
		 * subContact,sub.sub_phone1 AS
		 * subPhone,DATE_FORMAT(sub.sub_start_time,'%Y-%m-%d %H:%i:%s')AS
		 * subStartTime,DATE_FORMAT(sub.sub_end_time,'%Y-%m-%d %H:%i:%s') AS
		 * subEndTime, (CASE sub.sub_efficient WHEN 0 THEN 'N' WHEN 1 THEN 'Y'
		 * END)AS isEff FROM t_ent_subscription sub,t_pts_scheme sche WHERE
		 * sche.pk_id = sub.fk_sub_sch_id AND (sub.sub_enterprise_tag = 10010
		 * AND sub.sub_enterprise_name = 'chinasoft') ;
		 */
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append("SELECT  sche.pk_id AS scheCode,sche.sch_name AS scheName,sche.sch_type AS scheType,sche.sch_project_max AS scheMaxProject,sche.sch_ci_max AS scheMaxCi,");
		sqlClause.append("sche.sch_date_area AS scheServiceVali,sche.sch_dimensions AS scheDiments,");
		sqlClause.append("sub.pk_id AS subCode,sub.sub_email AS subEmail,sub.sub_contact AS subContact,sub.sub_phone1 AS subPhone,DATE_FORMAT(sub.sub_start_time,'%Y-%m-%d %H:%i:%s')AS subStartTime,DATE_FORMAT(sub.sub_end_time,'%Y-%m-%d %H:%i:%s') AS subEndTime,");
		sqlClause.append("(CASE sub.sub_efficient WHEN 0 THEN 'N' WHEN 1 THEN 'Y' END)AS isEff");
		sqlClause.append(" FROM t_ent_subscription sub,t_pts_scheme sche");
		sqlClause.append(" WHERE sche.pk_id = sub.fk_sub_sch_id ");
		sqlClause.append(" AND (sub.sub_enterprise_tag = ? AND sub.sub_enterprise_name = ?)");
		return this.exePrototypeSql(sqlClause.toString(), new Object[]{enterpriseTag,enterpriseName}, Schemesub.class).get(0);
	}
}
