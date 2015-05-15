package com.chinasoft.dao.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinasoft.dao.IExecuteSchemeDao;
import com.chinasoft.dbservice.dao.impl.BaseDAOImpl;
import com.chinasoft.entities.ExecuteScheme;

@Repository
public class ExecuteSchemeDaoImpl extends BaseDAOImpl<ExecuteScheme> implements
		IExecuteSchemeDao {

	@Override
	public List<ExecuteScheme> getExe() {
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append(" FROM  ExecuteScheme e");
		return this.find(sqlClause.toString());
	}

	@Override
	public Serializable saveBuild(long code) {
		ExecuteScheme es = new ExecuteScheme();
		es.setExe_operate_time(new Timestamp(System.currentTimeMillis()));
		es.setExe_create_time(new Timestamp(System.currentTimeMillis()));
		es.setFk_exe_ins_id(code);
		es.setExe_state(-1);
		return this.save(es);
	}

	@Override
	public Integer updateBuild(long code) {
		String sql = "UPDATE  t_ent_execute_scheme ts SET ts.exe_num=ts.exe_num+1,ts.exe_operate_time=NOW() WHERE ts.pk_id=?";
		return this.executeSql(sql, new Object[] { code });
	}

	@Override
	public ExecuteScheme getMaxExecuteSchemeByProjectId(Long proId)
			throws Exception {

		String hql = "from ExecuteScheme t where t.fk_exe_ins_id="
				+ proId
				+ " and t.exe_num = (select max(t1.exe_num) from ExecuteScheme t1 where t1.fk_exe_ins_id="
				+ proId + ")";

		List<ExecuteScheme> list = this.find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
