package com.chinasoft.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinasoft.dao.ResultExeInspDao;
import com.chinasoft.dbservice.dao.impl.BaseDAOImpl;
import com.chinasoft.entities.ResultExeInsp;

@Repository
public class ResultExeInspDaoImpl extends BaseDAOImpl<ResultExeInsp> implements ResultExeInspDao
{

	@Override
	public List<ResultExeInsp> get(long code)
	{
		/**
		 * 说明
		 * 结果呈现其中子表查询的功能是根据创建时间来过滤最新的构建结果
		 * SELECT insp.pk_id AS id, insp.ins_ci_scheme AS scheme,
		 * insp.ins_gitlab_name AS gitName, insp.ins_gitlab_branch AS gitBranch,
		 * CAST(tmp.exe_state AS CHAR) AS state,
		 * DATE_FORMAT(tmp.exe_create_time,'%Y-%m-%d %H:%i:%s') AS operTime FROM
		 * ( SELECT
		 * exe.pk_id,exe.fk_exe_ins_id,exe.exe_state,exe.exe_create_time FROM
		 * (SELECT * FROM t_ent_execute_scheme ent ORDER BY ent.exe_create_time
		 * DESC) exe GROUP BY (exe.fk_exe_ins_id) )tmp RIGHT JOIN
		 * t_ent_inspection_scheme insp ON insp.pk_id=tmp.fk_exe_ins_id WHERE
		 * insp.ins_ignore='0' ;
		 */
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append("SELECT insp.pk_id AS id,insp.ins_ci_scheme AS scheme,insp.ins_gitlab_name AS gitName,insp.ins_gitlab_branch AS gitBranch,");
		sqlClause.append("CAST(tmp.exe_state AS CHAR) AS state,DATE_FORMAT(tmp.exe_create_time,'%Y-%m-%d %H:%i:%s') AS operTime");
		sqlClause.append(" FROM (");
		sqlClause.append(" SELECT exe.pk_id,exe.fk_exe_ins_id,exe.exe_state,exe.exe_create_time");
		sqlClause.append(" FROM (SELECT * FROM t_ent_execute_scheme ent ORDER BY ent.exe_create_time DESC) exe");
		sqlClause.append(" GROUP BY (exe.fk_exe_ins_id) )tmp RIGHT JOIN t_ent_inspection_scheme insp");
		sqlClause.append(" ON insp.pk_id=tmp.fk_exe_ins_id  WHERE insp.ins_ignore='0'");
//		String className="com.chinasoft.entities.ExecuteScheme";
		return this.exePrototypeSql(sqlClause.toString(),null, ResultExeInsp.class);
	}
}
