package com.chinasoft.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TEntExecuteResult entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_ent_execute_result")
public class TEntExecuteResult implements java.io.Serializable {

	// Fields

	private Long pkId;
	private Long fkResInsId;
	private Long fkResExeId;
	private Long fkResAssId;
	private String resTarget;
	private Float resTargetResult;
	private String resRecorder;
	private Timestamp resOperateTime;
	private Timestamp resCreateTime;
	private Integer resIgnore;

	private Float resTargetScore;

	// Constructors

	/** default constructor */
	public TEntExecuteResult() {
	}

	/** minimal constructor */
	public TEntExecuteResult(Long fkResInsId, Long fkResExeId, Long fkResAssId,
			String resTarget, Float resTargetResult, Integer resIgnore) {
		this.fkResInsId = fkResInsId;
		this.fkResExeId = fkResExeId;
		this.fkResAssId = fkResAssId;
		this.resTarget = resTarget;
		this.resTargetResult = resTargetResult;
		this.resIgnore = resIgnore;
	}

	/** full constructor */
	public TEntExecuteResult(Long fkResInsId, Long fkResExeId, Long fkResAssId,
			String resTarget, Float resTargetResult, String resRecorder,
			Timestamp resOperateTime, Timestamp resCreateTime, Integer resIgnore) {
		this.fkResInsId = fkResInsId;
		this.fkResExeId = fkResExeId;
		this.fkResAssId = fkResAssId;
		this.resTarget = resTarget;
		this.resTargetResult = resTargetResult;
		this.resRecorder = resRecorder;
		this.resOperateTime = resOperateTime;
		this.resCreateTime = resCreateTime;
		this.resIgnore = resIgnore;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "pk_id", unique = true, nullable = false)
	public Long getPkId() {
		return this.pkId;
	}

	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}

	@Column(name = "fk_res_ins_id", nullable = false)
	public Long getFkResInsId() {
		return this.fkResInsId;
	}

	public void setFkResInsId(Long fkResInsId) {
		this.fkResInsId = fkResInsId;
	}

	@Column(name = "fk_res_exe_id", nullable = false)
	public Long getFkResExeId() {
		return this.fkResExeId;
	}

	public void setFkResExeId(Long fkResExeId) {
		this.fkResExeId = fkResExeId;
	}

	@Column(name = "fk_res_ass_id", nullable = false)
	public Long getFkResAssId() {
		return this.fkResAssId;
	}

	public void setFkResAssId(Long fkResAssId) {
		this.fkResAssId = fkResAssId;
	}

	@Column(name = "res_target", nullable = false)
	public String getResTarget() {
		return this.resTarget;
	}

	public void setResTarget(String resTarget) {
		this.resTarget = resTarget;
	}

	@Column(name = "res_target_result", nullable = false, precision = 12, scale = 0)
	public Float getResTargetResult() {
		return this.resTargetResult;
	}

	public void setResTargetResult(Float resTargetResult) {
		this.resTargetResult = resTargetResult;
	}

	@Column(name = "res_recorder")
	public String getResRecorder() {
		return this.resRecorder;
	}

	public void setResRecorder(String resRecorder) {
		this.resRecorder = resRecorder;
	}

	@Column(name = "res_operate_time", length = 0)
	public Timestamp getResOperateTime() {
		return this.resOperateTime;
	}

	public void setResOperateTime(Timestamp resOperateTime) {
		this.resOperateTime = resOperateTime;
	}

	@Column(name = "res_create_time", length = 0)
	public Timestamp getResCreateTime() {
		return this.resCreateTime;
	}

	public void setResCreateTime(Timestamp resCreateTime) {
		this.resCreateTime = resCreateTime;
	}

	@Column(name = "res_ignore", nullable = false)
	public Integer getResIgnore() {
		return this.resIgnore;
	}

	public void setResIgnore(Integer resIgnore) {
		this.resIgnore = resIgnore;
	}

	@Column(name = "res_target_score", nullable = false)
	public Float getResTargetScore() {
		return resTargetScore;
	}

	public void setResTargetScore(Float resTargetScore) {
		this.resTargetScore = resTargetScore;
	}

}