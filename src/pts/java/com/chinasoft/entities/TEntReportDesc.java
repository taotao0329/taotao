package com.chinasoft.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TEntReportDesc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_ent_report_desc")
public class TEntReportDesc implements java.io.Serializable {

	// Fields

	private Long id;
	private Long TEntExecuteSchemeId;
	private String packagePath;
	private String className;
	private String infoDesc;
	private Long TDicAssindexId;
	private String TDicAssindexName;
	private String subRecorder;
	private Timestamp subOperateTime;
	private Timestamp subCreateTime;
	private Integer subIgnore;
	private Long TEntExeId;

	// Constructors

	/** default constructor */
	public TEntReportDesc() {
	}

	/** full constructor */
	public TEntReportDesc(Long TEntExecuteSchemeId, String packagePath,
			String className, String infoDesc, Long TDicAssindexId,
			String TDicAssindexName, String subRecorder,
			Timestamp subOperateTime, Timestamp subCreateTime,
			Integer subIgnore, Long TEntExeId) {
		this.TEntExecuteSchemeId = TEntExecuteSchemeId;
		this.packagePath = packagePath;
		this.className = className;
		this.infoDesc = infoDesc;
		this.TDicAssindexId = TDicAssindexId;
		this.TDicAssindexName = TDicAssindexName;
		this.subRecorder = subRecorder;
		this.subOperateTime = subOperateTime;
		this.subCreateTime = subCreateTime;
		this.subIgnore = subIgnore;
		this.TEntExeId = TEntExeId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "t_ent_execute_scheme_id")
	public Long getTEntExecuteSchemeId() {
		return this.TEntExecuteSchemeId;
	}

	public void setTEntExecuteSchemeId(Long TEntExecuteSchemeId) {
		this.TEntExecuteSchemeId = TEntExecuteSchemeId;
	}

	@Column(name = "package_path", length = 1000)
	public String getPackagePath() {
		return this.packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	@Column(name = "class_name", length = 100)
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "info_desc", length = 65535)
	public String getInfoDesc() {
		return this.infoDesc;
	}

	public void setInfoDesc(String infoDesc) {
		this.infoDesc = infoDesc;
	}

	@Column(name = "t_dic_assindex_id")
	public Long getTDicAssindexId() {
		return this.TDicAssindexId;
	}

	public void setTDicAssindexId(Long TDicAssindexId) {
		this.TDicAssindexId = TDicAssindexId;
	}

	@Column(name = "t_dic_assindex_name", length = 50)
	public String getTDicAssindexName() {
		return this.TDicAssindexName;
	}

	public void setTDicAssindexName(String TDicAssindexName) {
		this.TDicAssindexName = TDicAssindexName;
	}

	@Column(name = "sub_recorder")
	public String getSubRecorder() {
		return this.subRecorder;
	}

	public void setSubRecorder(String subRecorder) {
		this.subRecorder = subRecorder;
	}

	@Column(name = "sub_operate_time", length = 0)
	public Timestamp getSubOperateTime() {
		return this.subOperateTime;
	}

	public void setSubOperateTime(Timestamp subOperateTime) {
		this.subOperateTime = subOperateTime;
	}

	@Column(name = "sub_create_time", length = 0)
	public Timestamp getSubCreateTime() {
		return this.subCreateTime;
	}

	public void setSubCreateTime(Timestamp subCreateTime) {
		this.subCreateTime = subCreateTime;
	}

	@Column(name = "sub_ignore")
	public Integer getSubIgnore() {
		return this.subIgnore;
	}

	public void setSubIgnore(Integer subIgnore) {
		this.subIgnore = subIgnore;
	}

	@Column(name = "t_ent_exe_id")
	public Long getTEntExeId() {
		return this.TEntExeId;
	}

	public void setTEntExeId(Long TEntExeId) {
		this.TEntExeId = TEntExeId;
	}

}