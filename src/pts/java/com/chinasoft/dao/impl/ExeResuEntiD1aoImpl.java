package com.chinasoft.dao.impl;

import org.springframework.stereotype.Repository;

import com.chinasoft.dao.ExeResuEntiDao;
import com.chinasoft.dbservice.dao.impl.BaseDAOImpl;
import com.chinasoft.entities.ExeResuEnti;

@Repository
public class ExeResuEntiD1aoImpl extends BaseDAOImpl<ExeResuEnti> implements ExeResuEntiDao
{

	@Override
	public ExeResuEnti getExeResu(long key1, long key2, String name)
	{
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append("SELECT  resu.res_target AS target,CAST(resu.res_target_result AS CHAR) AS result,CAST(resu.res_target_score AS CHAR) AS score");
		sqlClause.append(" FROM t_ent_execute_result resu WHERE resu.fk_res_ins_id=? AND resu.fk_res_exe_id=? AND resu.res_target=?");
		if (this.exePrototypeSql(sqlClause.toString(), new Object[]{key1,key2,name}, ExeResuEnti.class)!=null && this.exePrototypeSql(sqlClause.toString(), new Object[]{key1,key2,name}, ExeResuEnti.class).size()>0)
			return (ExeResuEnti) this.exePrototypeSql(sqlClause.toString(), new Object[]{key1,key2,name}, ExeResuEnti.class).get(0);
		else
			return null;
	}
}

