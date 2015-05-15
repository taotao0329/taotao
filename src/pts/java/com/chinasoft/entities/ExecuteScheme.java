package com.chinasoft.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 企业项目健康检查方案执行表
 * 
 * @author admin
 *
 */
@Entity
@Table(name = "t_ent_execute_scheme")
public class ExecuteScheme implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6489960053193475872L;
	// 标示
	@GenericGenerator(name = "", strategy = "increment")
	@Id
	@GeneratedValue()
	@Column(name = "pk_id", unique = true, nullable = false)
	private long pk_id;
	// 企业项目健康检查方案表标示
	@Column(name = "fk_exe_ins_id")
	private long fk_exe_ins_id;
	// 企业订购服务表 标示
	@Column(name = "fk_exe_sub_id")
	private long fk_exe_sub_id;
	// PTS服务订购方案表 标示
	@Column(name = "fk_exe_sch_id")
	private long fk_exe_sch_id;
	// 执行次数
	@Column(name = "exe_num")
	private int exe_num;
	// 执行状态 {0:成功 1:失败}
	@Column(name = "exe_state")
	private int exe_state;
	// 执行时长 {单位:秒}
	@Column(name = "exe_length")
	private long exe_length;
	// 记录操作人
	@Column(name = "exe_recorder")
	private String exe_recorder;
	// 记录操作时间
	@Column(name = "exe_operate_time")
	private Timestamp exe_operate_time;
	// 记录创建时间
	@Column(name = "exe_create_time")
	private Timestamp exe_create_time;
	// 记录删除标识{0:未删除 1:删除}
	@Column(name = "exe_ignore")
	private int exe_ignore;
	// 代码总行数
	@Column(name = "code_total_lines")
	private Long code_total_lines;

	// 非注释代码总行数
	@Column(name = "no_comment_lines")
	private Long no_comment_lines;

	// 文件个数
	@Column(name = "file_num")
	private Long file_num;

	// 注释代码总行数
	@Column(name = "comment_lines")
	private Long comment_lines;

	// 方法个数
	@Column(name = "function_num")
	private Long function_num;

	// 类个数
	@Column(name = "classes_num")
	private Long classes_num;

	// 目录个数
	@Column(name = "directory_num")
	private Long directory_num;

	public long getPk_id() {
		return pk_id;
	}

	public void setPk_id(long pk_id) {
		this.pk_id = pk_id;
	}

	public long getFk_exe_ins_id() {
		return fk_exe_ins_id;
	}

	public void setFk_exe_ins_id(long fk_exe_ins_id) {
		this.fk_exe_ins_id = fk_exe_ins_id;
	}

	public long getFk_exe_sub_id() {
		return fk_exe_sub_id;
	}

	public void setFk_exe_sub_id(long fk_exe_sub_id) {
		this.fk_exe_sub_id = fk_exe_sub_id;
	}

	public long getFk_exe_sch_id() {
		return fk_exe_sch_id;
	}

	public void setFk_exe_sch_id(long fk_exe_sch_id) {
		this.fk_exe_sch_id = fk_exe_sch_id;
	}

	public int getExe_num() {
		return exe_num;
	}

	public void setExe_num(int exe_num) {
		this.exe_num = exe_num;
	}

	public int getExe_state() {
		return exe_state;
	}

	public void setExe_state(int exe_state) {
		this.exe_state = exe_state;
	}

	public long getExe_length() {
		return exe_length;
	}

	public void setExe_length(long exe_length) {
		this.exe_length = exe_length;
	}

	public String getExe_recorder() {
		return exe_recorder;
	}

	public void setExe_recorder(String exe_recorder) {
		this.exe_recorder = exe_recorder;
	}

	public Timestamp getExe_operate_time() {
		return exe_operate_time;
	}

	public void setExe_operate_time(Timestamp exe_operate_time) {
		this.exe_operate_time = exe_operate_time;
	}

	public Timestamp getExe_create_time() {
		return exe_create_time;
	}

	public void setExe_create_time(Timestamp exe_create_time) {
		this.exe_create_time = exe_create_time;
	}

	public int getExe_ignore() {
		return exe_ignore;
	}

	public void setExe_ignore(int exe_ignore) {
		this.exe_ignore = exe_ignore;
	}

	public Long getCode_total_lines() {
		return code_total_lines;
	}

	public void setCode_total_lines(Long code_total_lines) {
		this.code_total_lines = code_total_lines;
	}

	public Long getNo_comment_lines() {
		return no_comment_lines;
	}

	public void setNo_comment_lines(Long no_comment_lines) {
		this.no_comment_lines = no_comment_lines;
	}

	public Long getFile_num() {
		return file_num;
	}

	public void setFile_num(Long file_num) {
		this.file_num = file_num;
	}

	public Long getComment_lines() {
		return comment_lines;
	}

	public void setComment_lines(Long comment_lines) {
		this.comment_lines = comment_lines;
	}

	public Long getFunction_num() {
		return function_num;
	}

	public void setFunction_num(Long function_num) {
		this.function_num = function_num;
	}

	public Long getClasses_num() {
		return classes_num;
	}

	public void setClasses_num(Long classes_num) {
		this.classes_num = classes_num;
	}

	public Long getDirectory_num() {
		return directory_num;
	}

	public void setDirectory_num(Long directory_num) {
		this.directory_num = directory_num;
	}

}
