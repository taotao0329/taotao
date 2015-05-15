package com.chinasoft.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinasoft.dao.CompileDescDao;
import com.chinasoft.dbservice.dao.impl.BaseDAOImpl;
import com.chinasoft.entities.CompileDesc;

@Repository
public class CompileDescDaoImpl extends BaseDAOImpl<CompileDesc> implements CompileDescDao
{

	@Override
	public List<CompileDesc> getCompileDesc(long exeId,long inspId)
	{
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append("SELECT comp.pk_id AS id,comp.fk_bui_ins_id AS insCode,comp.fk_bui_exe_id AS exeCode,comp.bui_warning_num AS warningNum,comp.bui_warning_content AS warningText,");
		sqlClause.append("comp.bui_error_num AS errNum,comp.bui_error_content  AS errText,comp.bui_info_num AS infoNum,comp.bui_info_content AS infoText,");
		sqlClause.append("DATE_FORMAT(comp.bui_operate_time, '%Y-%m-%d %H:%i:%s')AS operTime,");
		sqlClause.append("(SELECT insp.ins_ci_scheme FROM t_ent_inspection_scheme insp WHERE insp.pk_id=comp.fk_bui_ins_id ) AS ciName");
		sqlClause.append(" FROM t_scheme_builds comp where comp.fk_bui_exe_id=? and comp.fk_bui_ins_id=?");
		return this.exePrototypeSql(sqlClause.toString(), new Object[]{exeId,inspId}, CompileDesc.class);
	}
}
