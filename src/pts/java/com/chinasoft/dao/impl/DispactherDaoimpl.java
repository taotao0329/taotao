package com.chinasoft.dao.impl;

import java.math.BigInteger;
import org.springframework.stereotype.Repository;
import com.chinasoft.dao.DispactherDao;
import com.chinasoft.dbservice.dao.impl.BaseDAOImpl;
import com.chinasoft.entities.MainInfo;

@Repository
public class DispactherDaoimpl extends BaseDAOImpl<MainInfo> implements DispactherDao 
{

	@Override
	public BigInteger validateJF(Object[] param)
	{
		StringBuffer  sqlClause = new StringBuffer();
		sqlClause.append("SELECT CAST(COUNT(1) AS SIGNED INTEGER)");
		sqlClause.append(" FROM t_ent_scheme_power p,t_ent_inspection_scheme ins");
		sqlClause.append(" WHERE ins.pk_id=p.fk_pow_ins_id");
		sqlClause.append(" AND (p.pow_name=? OR p.pow_user=?) AND (ins.ins_enterprise_tag=? AND ins.ins_enterprise_name=?) AND (ins_project_name= ? AND ins.ins_project_tag=?)");
		return  this.countForSql(sqlClause.toString(), param);
	}
	
}
