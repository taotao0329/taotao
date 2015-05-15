package com.chinasoft.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * PTS服务方案表实体对象
 * @author admin
 *
 */
@Entity
@Table(name = "t_pts_scheme")
public class PtsScheme implements Serializable
{
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 7757774132334718483L;
	/** 标示*/
	@GenericGenerator(strategy = "increment", name = "")
	@Id
	@GeneratedValue()
	@Column(name = "pk_id", unique = true, nullable = false)
	private long pk_id;
	/** PTS服务方案名称*/
	@Column(name = "sch_name")
	private String sch_name;
	/** PTS服务方案类型*/
	@Column(name = "sch_type")
	private int sch_type;
	/** 最大服务项目个数*/
	@Column(name = "sch_project_max")
	private int sch_project_max;
	/** 最大持续集成最大方案个数*/
	@Column(name = "sch_ci_max")
	private int sch_ci_max;
	/** 服务时间范围 */
	@Column(name = "sch_date_area")
	private int sch_date_area;
	/** 服务维度*/
	@Column(name = "sch_dimensions")
	private String sch_dimensions;
	/** 服务优先级*/
	@Column(name = "sch_pri")
	private int sch_pri;
	/** 方案金额*/
	@Column(name = "sch_money")
	private BigDecimal sch_money;
	/** 记录操作人*/
	@Column(name = "sch_recorder")
	private String sch_recorder;
	/** 记录操作时间*/
	@Column(name = "sch_operate_time")
	private Timestamp sch_operate_time;
	/** 记录创建时间*/
	@Column(name = "sch_create_time")
	private Timestamp sch_create_time;
	/** 记录删除标识*/
	@Column(name = "sch_ignore")
	private int sch_ignore;
	
	public long getPk_id()
	{
		return pk_id;
	}
	public void setPk_id(long pk_id)
	{
		this.pk_id = pk_id;
	}
	public String getSch_name()
	{
		return sch_name;
	}
	public void setSch_name(String sch_name)
	{
		this.sch_name = sch_name;
	}
	public int getSch_type()
	{
		return sch_type;
	}
	public void setSch_type(int sch_type)
	{
		this.sch_type = sch_type;
	}
	public int getSch_project_max()
	{
		return sch_project_max;
	}
	public void setSch_project_max(int sch_project_max)
	{
		this.sch_project_max = sch_project_max;
	}
	public int getSch_ci_max()
	{
		return sch_ci_max;
	}
	public void setSch_ci_max(int sch_ci_max)
	{
		this.sch_ci_max = sch_ci_max;
	}
	public int getSch_date_area()
	{
		return sch_date_area;
	}
	public void setSch_date_area(int sch_date_area)
	{
		this.sch_date_area = sch_date_area;
	}
	public String getSch_dimensions()
	{
		return sch_dimensions;
	}
	public void setSch_dimensions(String sch_dimensions)
	{
		this.sch_dimensions = sch_dimensions;
	}
	public int getSch_pri()
	{
		return sch_pri;
	}
	public void setSch_pri(int sch_pri)
	{
		this.sch_pri = sch_pri;
	}
	public BigDecimal getSch_money()
	{
		return sch_money;
	}
	public void setSch_money(BigDecimal sch_money)
	{
		this.sch_money = sch_money;
	}
	public String getSch_recorder()
	{
		return sch_recorder;
	}
	public void setSch_recorder(String sch_recorder)
	{
		this.sch_recorder = sch_recorder;
	}
	public Timestamp getSch_operate_time()
	{
		return sch_operate_time;
	}
	public void setSch_operate_time(Timestamp sch_operate_time)
	{
		this.sch_operate_time = sch_operate_time;
	}
	public Timestamp getSch_create_time()
	{
		return sch_create_time;
	}
	public void setSch_create_time(Timestamp sch_create_time)
	{
		this.sch_create_time = sch_create_time;
	}
	public int getSch_ignore()
	{
		return sch_ignore;
	}
	public void setSch_ignore(int sch_ignore)
	{
		this.sch_ignore = sch_ignore;
	}
	
	
}
