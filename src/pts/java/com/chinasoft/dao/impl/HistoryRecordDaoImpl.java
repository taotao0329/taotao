package com.chinasoft.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinasoft.dao.HistoryRecordDao;
import com.chinasoft.dbservice.dao.impl.BaseDAOImpl;
import com.chinasoft.entities.HistoryRecord;

@Repository
public class HistoryRecordDaoImpl extends BaseDAOImpl<HistoryRecord> implements HistoryRecordDao
{

	/**
	 * 
	 */
	@Override
	public List<HistoryRecord> getHistory(long id)
	{
		/**
		 * SELECT exe.pk_id AS exeId, exe.fk_exe_ins_id AS inspId, (SELECT
		 * ins_ci_scheme FROM t_ent_inspection_scheme insp WHERE
		 * insp.pk_id=exe.fk_exe_ins_id) AS scheName, exe.exe_state AS state,
		 * DATE_FORMAT(exe.exe_create_time,'%Y-%m-%d %H:%i:%s') AS createTime,
		 * CAST( CAST( (SELECT COUNT(1) FROM t_ent_execute_scheme
		 * exe,t_ent_inspection_scheme insp WHERE insp.pk_id=exe.fk_exe_ins_id
		 * AND (exe.exe_state=1 AND exe.fk_exe_ins_id=73))/(SELECT COUNT(1) FROM
		 * t_ent_execute_scheme exe,t_ent_inspection_scheme insp WHERE
		 * insp.pk_id=exe.fk_exe_ins_id AND exe.fk_exe_ins_id=73) AS DECIMAL (4,
		 * 2))*100 AS CHAR) AS odds FROM t_ent_execute_scheme exe WHERE
		 * exe.fk_exe_ins_id=73 ORDER BY exe.exe_create_time DESC ;
		 */
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append("SELECT exe.pk_id AS exeId,exe.fk_exe_ins_id AS inspId,");
		sqlClause.append("(SELECT ins_ci_scheme FROM t_ent_inspection_scheme insp WHERE insp.pk_id=exe.fk_exe_ins_id) AS scheName,");
		sqlClause.append("cast(exe.exe_state as char) AS state,");
		sqlClause.append("DATE_FORMAT(exe.exe_create_time,'%Y-%m-%d %H:%i:%s') AS createTime,");
		sqlClause.append("CAST(CAST((SELECT COUNT(1)FROM t_ent_execute_scheme exe,t_ent_inspection_scheme insp WHERE insp.pk_id=exe.fk_exe_ins_id AND (exe.exe_state=1 AND exe.fk_exe_ins_id=?))/(SELECT COUNT(1)");
		sqlClause.append("FROM t_ent_execute_scheme exe,t_ent_inspection_scheme insp WHERE insp.pk_id=exe.fk_exe_ins_id AND exe.fk_exe_ins_id=?)");
		sqlClause.append(" AS DECIMAL (4, 2))*100 AS CHAR) AS odds");
		sqlClause.append(" FROM t_ent_execute_scheme exe");
		sqlClause.append(" WHERE exe.fk_exe_ins_id=?");
		sqlClause.append(" ORDER BY exe.exe_create_time DESC");
		return this.exePrototypeSql(sqlClause.toString(), new Object[]{id,id,id}, HistoryRecord.class);
	}
	
}
