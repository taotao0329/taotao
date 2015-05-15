package com.chinasoft.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinasoft.dao.IPermissDao;
import com.chinasoft.dbservice.dao.impl.BaseDAOImpl;
import com.chinasoft.entities.Permiss;

@Repository
public class PermissDaoImpl extends BaseDAOImpl<Permiss> implements IPermissDao
{

	@Override
	public List<Permiss> getAccess()
	{
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append(" FROM  Permiss e");
		return this.find(sqlClause.toString());
	}

	@Override
	public Serializable savePermiss(Permiss per)
	{
		return this.save(per);
	}

	@Override
	public void updatePermiss(Permiss per)
	{
		 this.update(per);
		
	}

	@Override
	public void deletePer(long id)
	{
		String sql="delete from Permiss ins where ins.pk_id="+id;
		this.executeHql(sql);
	}

	@Override
	public Permiss getPermiss(long code)
	{
		String hql="FROM  Permiss where pk_id="+code;
		return this.find(hql).get(0);
	}

	@Override
	public BigInteger validateJF(Object[] param)
	{
		StringBuffer  sqlClause = new StringBuffer();
		sqlClause.append("SELECT CAST(COUNT(1) AS SIGNED INTEGER)");
		sqlClause.append(" FROM t_ent_scheme_power p,t_ent_inspection_scheme ins");
		sqlClause.append(" WHERE ins.pk_id=p.fk_pow_ins_id");
		sqlClause.append(" AND (p.pow_name=? OR p.pow_user=?) AND (ins.ins_enterprise_tag=? AND ins.ins_enterprise_name=?) AND (ins_project_name= ? AND ins.ins_project_tag=?)");
		return this.countForSql(sqlClause.toString(), param);
	}
	
}
