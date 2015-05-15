package com.chinasoft.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.chinasoft.dao.NoticeSysDao;
import com.chinasoft.dbservice.dao.impl.BaseDAOImpl;
import com.chinasoft.entities.NoticeSys;

@Repository
public class NoticeSysDaoImpl extends BaseDAOImpl<NoticeSys> implements NoticeSysDao
{

	@Override
	public List<NoticeSys> get()
	{
		/**
		 * 默认查询一个月内的通告显示前五条记录按照发布时间倒序
		 * SELECT pts.noticeCode,pts.title,pts.text,CAST(pts.publishBeginTime AS
		 * CHAR)AS publishBeginTime , CAST(pts.publishEndTime AS CHAR) AS
		 * publishEndTime FROM t_pts_notice pts WHERE (NOW() BETWEEN
		 * pts.publishBeginTime AND pts.publishEndTime AND pts.messageType=1 AND
		 * pts.status=1) ORDER BY pts.publishBeginTime DESC LIMIT 0, 5 ;
		 */
		StringBuffer sqlClause = new StringBuffer();
		sqlClause.append("SELECT pts.noticeCode,pts.title,pts.text,DATE_FORMAT(pts.publishBeginTime,'%Y-%m-%d')AS publishBeginTime , DATE_FORMAT(pts.publishEndTime,'%Y-%m-%d') AS publishEndTime");
		sqlClause.append(" FROM t_pts_notice pts");
		sqlClause.append(" WHERE (NOW() BETWEEN pts.publishBeginTime AND pts.publishEndTime AND pts.messageType=1 AND pts.status=1)");
		sqlClause.append(" ORDER BY pts.publishBeginTime DESC LIMIT 0, 5");
		return this.exePrototypeSql(sqlClause.toString(), null, NoticeSys.class);
	}
	
}
