package com.chinasoft.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinasoft.dao.InspectionDao;
import com.chinasoft.dbservice.dao.impl.BaseDAOImpl;
import com.chinasoft.entities.InspectionScheme;

@Repository
public class InspectionDaoimpl extends BaseDAOImpl<InspectionScheme> implements InspectionDao
{

	@Override
	public List<InspectionScheme> findAll(Object[] param)
	{
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append(" FROM  InspectionScheme ins where ins.ins_enterprise_tag=? and ins.ins_enterprise_name=? and ins.ins_project_tag=? and ins.ins_project_name=? ");
		return this.find(sqlClause.toString(), param);
	}

	@Override
	public void deleteObj(long id)
	{
		//update InspectionScheme  ins set ins.ins_ignore=1 where ins.pk_id=
		//delete from InspectionScheme ins where ins.pk_id=
		String sql="update InspectionScheme  ins set ins.ins_ignore=1 where ins.pk_id="+id;
		this.executeHql(sql);
	}

	@Override
	public Serializable saveInspe(InspectionScheme sche)
	{
		return this.save(sche);
	}

	@Override
	public InspectionScheme getInspect(long id)
	{
		String hql="FROM  InspectionScheme where pk_id="+id;
		return this.find(hql) !=null && this.find(hql).size()>0 ? this.find(hql).get(0):null;
	}

	@Override
	public void updateInspe(InspectionScheme ins)
	{
		this.update(ins);
	}

	@Override
	public void updateServiceStatus(long id)
	{
		this.get(InspectionScheme.class, id);
		
	}

	@Override
	public Integer updateObj(long id,int status,int statType)
	{
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append("update InspectionScheme  ins");
		
		if(statType==-1)
		{
			sqlClause.append(" set ins.ins_ignore='"+status+"'");
		}else if(status == -1)
		{
			sqlClause.append(" set ins.ins_scheme_state='"+statType+"'");
		}
		sqlClause.append(" where ins.pk_id='"+id+"'");
		Integer resu;
		resu = this.executeHql(sqlClause.toString());
		return resu;
	}
}
