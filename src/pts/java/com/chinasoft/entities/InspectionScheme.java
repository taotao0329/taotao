package com.chinasoft.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "t_ent_inspection_scheme")
public class InspectionScheme implements Serializable
{
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -9202683036293263316L;
	//标示
	@GenericGenerator(name = "", strategy = "increment")
	@Id
	@GeneratedValue()
	@Column(name = "pk_id", unique = true, nullable = false)
	private long pk_id;
	//企业订购服务标识
	@Column(name = "fk_ins_sub_id")
	private long fk_ins_sub_id;
	//企业标识
	@Column(name = "ins_enterprise_tag")
	private String ins_enterprise_tag;
	//企业名称
	@Column(name = "ins_enterprise_name")
	private String ins_enterprise_name;
	//隶属持续集成服务器IP
	@Column(name = "fk_ins_ser_ip")
	private String fk_ins_ser_ip;
	//项目标识
	@Column(name = "ins_project_tag")
	private String ins_project_tag;
	//项目名称
	@Column(name = "ins_project_name")
	private String ins_project_name;
	//代码工程类型
	@Column(name = "ins_project_type")
	private String ins_project_type;
	//Git仓库名称
	@Column(name = "ins_gitlab_name")
	private String ins_gitlab_name;
	//Git仓库URI地址
	@Column(name = "ins_gitlab_url")
	private String ins_gitlab_url;
	//Git仓库分支名称
	@Column(name = "ins_gitlab_branch")
	private String ins_gitlab_branch;
	//PTS服务方案名称
	@Column(name = "ins_pts_scheme")
	private String ins_pts_scheme;
	//PTS服务方案标识
	@Column(name = "fk_ins_sch_id")
	private long fk_ins_sch_id;
	//构建类型
	@Column(name = "ins_build_type")
	private int ins_build_type;
	//定时构建类型
	@Column(name = "ins_time_build_type")
	private int ins_time_build_type;
	//定时构建时间
	@Column(name = "ins_time_build_time")
	private Timestamp ins_time_build_time;
	//定时构建循环周期类型
	@Column(name = "ins_cyc_type")
	private int ins_cyc_type;
	//定时构建月循环类型执行日期
	@Column(name = "ins_month_days")
	private String ins_month_days;
	//定时构建周循环类型执行日期
	@Column(name = "ins_week_days")
	private String ins_week_days;
	//授权人账户
	@Column(name = "ins_accredit")
	private String ins_accredit;
	//方案状态
	@Column(name = "ins_scheme_state")
	private int ins_scheme_state;
	//记录操作人
	@Column(name = "ins_recorder")
	private String ins_recorder;
	//记录操作时间
	@Column(name = "ins_operate_time")
	private Timestamp ins_operate_time;
	//记录创建时间
	@Column(name = "ins_create_time")
	private Timestamp ins_create_time;
	//记录删除标识
	@Column(name = "ins_ignore")
	private int ins_ignore;
	//方案名
	@Column(name="ins_ci_scheme")
	private String ins_ci_scheme;
	//检查维度
	@Column(name="ins_ci_diment")
	private String ins_check_diment;
	
	//每天 每周 每月的构建时间 {HH:mi:ss}
	@Column(name="ins_exetime")
	private String ins_exetime;
	
	
	public String getIns_exetime()
	{
		return ins_exetime;
	}
	public void setIns_exetime(String ins_exetime)
	{
		this.ins_exetime = ins_exetime;
	}
	public String getIns_ci_scheme()
	{
		return ins_ci_scheme;
	}
	public void setIns_ci_scheme(String ins_ci_scheme)
	{
		this.ins_ci_scheme = ins_ci_scheme;
	}
	public long getPk_id()
	{
		return pk_id;
	}
	public void setPk_id(long pk_id)
	{
		this.pk_id = pk_id;
	}
	public long getFk_ins_sub_id()
	{
		return fk_ins_sub_id;
	}
	public void setFk_ins_sub_id(long fk_ins_sub_id)
	{
		this.fk_ins_sub_id = fk_ins_sub_id;
	}
	public String getIns_enterprise_tag()
	{
		return ins_enterprise_tag;
	}
	public void setIns_enterprise_tag(String ins_enterprise_tag)
	{
		this.ins_enterprise_tag = ins_enterprise_tag;
	}
	public String getIns_enterprise_name()
	{
		return ins_enterprise_name;
	}
	public void setIns_enterprise_name(String ins_enterprise_name)
	{
		this.ins_enterprise_name = ins_enterprise_name;
	}
	public String getFk_ins_ser_ip()
	{
		return fk_ins_ser_ip;
	}
	public void setFk_ins_ser_ip(String fk_ins_ser_ip)
	{
		this.fk_ins_ser_ip = fk_ins_ser_ip;
	}
	public String getIns_project_tag()
	{
		return ins_project_tag;
	}
	public void setIns_project_tag(String ins_project_tag)
	{
		this.ins_project_tag = ins_project_tag;
	}
	public String getIns_project_name()
	{
		return ins_project_name;
	}
	public void setIns_project_name(String ins_project_name)
	{
		this.ins_project_name = ins_project_name;
	}
	public String getIns_project_type()
	{
		return ins_project_type;
	}
	public void setIns_project_type(String ins_project_type)
	{
		this.ins_project_type = ins_project_type;
	}
	public String getIns_gitlab_name()
	{
		return ins_gitlab_name;
	}
	public void setIns_gitlab_name(String ins_gitlab_name)
	{
		this.ins_gitlab_name = ins_gitlab_name;
	}
	public String getIns_gitlab_url()
	{
		return ins_gitlab_url;
	}
	public void setIns_gitlab_url(String ins_gitlab_url)
	{
		this.ins_gitlab_url = ins_gitlab_url;
	}
	public String getIns_gitlab_branch()
	{
		return ins_gitlab_branch;
	}
	public void setIns_gitlab_branch(String ins_gitlab_branch)
	{
		this.ins_gitlab_branch = ins_gitlab_branch;
	}
	public String getIns_pts_scheme()
	{
		return ins_pts_scheme;
	}
	public void setIns_pts_scheme(String ins_pts_scheme)
	{
		this.ins_pts_scheme = ins_pts_scheme;
	}
	public long getFk_ins_sch_id()
	{
		return fk_ins_sch_id;
	}
	public void setFk_ins_sch_id(long fk_ins_sch_id)
	{
		this.fk_ins_sch_id = fk_ins_sch_id;
	}
	public int getIns_build_type()
	{
		return ins_build_type;
	}
	public void setIns_build_type(int ins_build_type)
	{
		this.ins_build_type = ins_build_type;
	}
	public int getIns_time_build_type()
	{
		return ins_time_build_type;
	}
	public void setIns_time_build_type(int ins_time_build_type)
	{
		this.ins_time_build_type = ins_time_build_type;
	}
	
	
	public Timestamp getIns_time_build_time()
	{
		return ins_time_build_time;
	}
	public void setIns_time_build_time(Timestamp ins_time_build_time)
	{
		this.ins_time_build_time = ins_time_build_time;
	}
	public int getIns_cyc_type()
	{
		return ins_cyc_type;
	}
	public void setIns_cyc_type(int ins_cyc_type)
	{
		this.ins_cyc_type = ins_cyc_type;
	}
	public String getIns_month_days()
	{
		return ins_month_days;
	}
	public void setIns_month_days(String ins_month_days)
	{
		this.ins_month_days = ins_month_days;
	}
	public String getIns_week_days()
	{
		return ins_week_days;
	}
	public void setIns_week_days(String ins_week_days)
	{
		this.ins_week_days = ins_week_days;
	}
	public String getIns_accredit()
	{
		return ins_accredit;
	}
	public void setIns_accredit(String ins_accredit)
	{
		this.ins_accredit = ins_accredit;
	}
	public int getIns_scheme_state()
	{
		return ins_scheme_state;
	}
	public void setIns_scheme_state(int ins_scheme_state)
	{
		this.ins_scheme_state = ins_scheme_state;
	}
	public String getIns_recorder()
	{
		return ins_recorder;
	}
	public void setIns_recorder(String ins_recorder)
	{
		this.ins_recorder = ins_recorder;
	}
	public Timestamp getIns_operate_time()
	{
		return ins_operate_time;
	}
	public void setIns_operate_time(Timestamp ins_operate_time)
	{
		this.ins_operate_time = ins_operate_time;
	}
	public Timestamp getIns_create_time()
	{
		return ins_create_time;
	}
	public void setIns_create_time(Timestamp ins_create_time)
	{
		this.ins_create_time = ins_create_time;
	}
	public int getIns_ignore()
	{
		return ins_ignore;
	}
	public void setIns_ignore(int ins_ignore)
	{
		this.ins_ignore = ins_ignore;
	}
	public String getIns_check_diment()
	{
		return ins_check_diment;
	}
	public void setIns_check_diment(String ins_check_diment)
	{
		this.ins_check_diment = ins_check_diment;
	}
	
	
	
}
