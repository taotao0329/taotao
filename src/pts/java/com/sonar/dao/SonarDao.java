package com.sonar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.chinasoft.entities.NormDesc;
import com.jdbc.util.DBManager;

/**
 * 
 * 获取去sonar同步结果
 * 
 * @author TT
 *
 */
public class SonarDao {

	private Logger log = Logger.getLogger(SonarDao.class);

	private Connection conn;

	private PreparedStatement ps;

	private Statement s;

	private ResultSet rs;

	/**
	 * 获取项目复杂度
	 * 
	 * @param projectName
	 * @return
	 * @throws Exception
	 */
	public Double getComplexity(Long projectName) {

		conn = DBManager.getConnection();
		Double result = 0.0;
		try {
			String sql = "SELECT MAX(t3.value) as num FROM project_measures t3 WHERE t3.metric_id=20 AND t3.snapshot_id IN ( SELECT t2.id FROM snapshots t2 WHERE t2.project_id IN (SELECT t1.id FROM projects t1 WHERE t1.root_id =  (SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.scope='FIL')) ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getDouble("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;

	}

	/**
	 * 平均文件
	 * 
	 * @param projectName
	 * @return
	 */
	public Double getAvgFileComplexity(Long projectName) {

		conn = DBManager.getConnection();
		Double result = 0.0;
		try {
			String sql = "SELECT AVG(t3.value) as num FROM project_measures t3 WHERE t3.metric_id=21 AND t3.snapshot_id IN ( SELECT t2.id FROM snapshots t2 WHERE t2.project_id IN (SELECT t1.id FROM projects t1 WHERE t1.root_id =  (SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.scope='FIL')) ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getDouble("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;

	}

	/**
	 * 平均方法复杂度
	 * 
	 * @param projectName
	 * @return
	 */
	public Double getAvgFunctionComplexity(Long projectName) {

		conn = DBManager.getConnection();
		Double result = 0.0;
		try {
			String sql = "SELECT AVG(t3.value)  as num FROM project_measures t3 WHERE t3.metric_id=25 AND t3.snapshot_id IN ( SELECT t2.id FROM snapshots t2 WHERE t2.project_id IN (SELECT t1.id FROM projects t1 WHERE t1.root_id =  (SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.scope='FIL')) ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getDouble("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;

	}

	/**
	 * 平均类复杂度
	 * 
	 * @param projectName
	 * @return
	 */
	public Double getAvgClassComplexity(Long projectName) {

		conn = DBManager.getConnection();
		Double result = 0.0;
		try {
			String sql = "SELECT AVG(t3.value)  as num FROM project_measures t3 WHERE t3.metric_id=23 AND t3.snapshot_id IN ( SELECT t2.id FROM snapshots t2 WHERE t2.project_id IN (SELECT t1.id FROM projects t1 WHERE t1.root_id =  (SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.scope='FIL')) ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getDouble("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;

	}

	/**
	 * 查看重复代码总行数
	 * 
	 * @param projectName
	 * @return
	 */
	public Double getRepetitionLine(Long projectName) {
		conn = DBManager.getConnection();
		Double result = 0.0;
		try {
			String sql = "SELECT t2.value as num FROM project_measures t2 WHERE t2.metric_id=87 AND t2.snapshot_id = ("
					+ "SELECT t1.id FROM snapshots t1 WHERE t1.project_id = ("
					+ "SELECT t.id FROM projects t WHERE t.name='"
					+ projectName + "' AND t.scope='PRJ') AND t1.islast=1 )";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getDouble("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 查看重复代码块数
	 * 
	 * @param projectName
	 * @return
	 */
	public Double getRepetitionBlocks(Long projectName) {

		conn = DBManager.getConnection();
		Double result = 0.0;
		try {
			String sql = "SELECT t2.value as num FROM project_measures t2 WHERE t2.metric_id=88 AND t2.snapshot_id = ("
					+ "SELECT t1.id FROM snapshots t1 WHERE t1.project_id = ("
					+ "SELECT t.id FROM projects t WHERE t.name='"
					+ projectName + "' AND t.scope='PRJ') AND t1.islast=1 )";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getDouble("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 查看代码重复率
	 * 
	 * @param projectName
	 * @return
	 */
	public Double getRepetitionProportion(Long projectName) {

		conn = DBManager.getConnection();
		Double result = 0.0;
		try {
			String sql = "SELECT t2.value as num FROM project_measures t2 WHERE t2.metric_id=90 AND t2.snapshot_id = ("
					+ "SELECT t1.id FROM snapshots t1 WHERE t1.project_id = ("
					+ "SELECT t.id FROM projects t WHERE t.name='"
					+ projectName + "' AND t.scope='PRJ') AND t1.islast=1 )";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getDouble("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 注释率
	 * 
	 * @param projectName
	 * @return
	 */
	public Double getCommentLinesDensity(Long projectName) {

		conn = DBManager.getConnection();
		Double result = 0.0;
		try {
			String sql = "SELECT t2.value as num FROM project_measures t2 WHERE t2.metric_id=16 AND t2.snapshot_id = ("
					+ "SELECT t1.id FROM snapshots t1 WHERE t1.project_id = ("
					+ "SELECT t.id FROM projects t WHERE t.name='119' AND t.scope='PRJ') AND t1.islast=1) ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getDouble("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 阻断
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getBlockerCount(Long projectName) {

		conn = DBManager.getConnection();
		Integer result = 0;
		try {
			String sql = "SELECT COUNT(1) as num FROM issues t1 WHERE t1.root_component_id = ("
					+ "SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.severity='BLOCKER'; ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getInt("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 严重
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getCriticalCount(Long projectName) {

		conn = DBManager.getConnection();
		Integer result = 0;
		try {
			String sql = "SELECT COUNT(1) as num FROM issues t1 WHERE t1.root_component_id = ("
					+ "SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.severity='CRITICAL'; ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getInt("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 主要
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getMajorCount(Long projectName) {

		conn = DBManager.getConnection();
		Integer result = 0;
		try {
			String sql = "SELECT COUNT(1) as num FROM issues t1 WHERE t1.root_component_id = ("
					+ "SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.severity='MAJOR'; ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getInt("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 次要
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getMinorCount(Long projectName) {

		conn = DBManager.getConnection();
		Integer result = 0;
		try {
			String sql = "SELECT COUNT(1) as num FROM issues t1 WHERE t1.root_component_id = ("
					+ "SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.severity='MINOR'; ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getInt("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 信息
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getInfoCount(Long projectName) {

		conn = DBManager.getConnection();
		Integer result = 0;
		try {
			String sql = "SELECT COUNT(1) as num FROM issues t1 WHERE t1.root_component_id = ("
					+ "SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.severity='INFO'; ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getInt("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 统计代码总行数
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getTotalLines(Long projectName) {
		conn = DBManager.getConnection();
		Integer result = 0;
		try {
			String sql = " SELECT SUM(t3.value) as num FROM project_measures t3 WHERE t3.metric_id=1 AND t3.snapshot_id IN ("
					+ "SELECT t2.id FROM snapshots t2 WHERE t2.islast=1 AND  t2.project_id IN ("
					+ "SELECT t1.id FROM projects t1 WHERE t1.root_id ="
					+ "(SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.scope='FIL') ) ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getInt("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 非注释代码总行数
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getNoCommentLines(Long projectName) {
		conn = DBManager.getConnection();
		Integer result = 0;
		try {
			String sql = " SELECT SUM(t3.value) as num FROM project_measures t3 WHERE t3.metric_id=3 AND t3.snapshot_id IN ("
					+ "SELECT t2.id FROM snapshots t2 WHERE t2.islast=1 AND  t2.project_id IN ("
					+ "SELECT t1.id FROM projects t1 WHERE t1.root_id ="
					+ "(SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.scope='FIL') ) ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getInt("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 文件个数
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getFileCount(Long projectName) {
		conn = DBManager.getConnection();
		Integer result = 0;
		try {
			String sql = " SELECT SUM(t3.value) as num FROM project_measures t3 WHERE t3.metric_id=7 AND t3.snapshot_id IN ("
					+ "SELECT t2.id FROM snapshots t2 WHERE t2.islast=1 AND  t2.project_id IN ("
					+ "SELECT t1.id FROM projects t1 WHERE t1.root_id ="
					+ "(SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.scope='FIL') ) ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getInt("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 方法个数
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getFunctionCount(Long projectName) {
		conn = DBManager.getConnection();
		Integer result = 0;
		try {
			String sql = " SELECT SUM(t3.value) as num FROM project_measures t3 WHERE t3.metric_id=10 AND t3.snapshot_id IN ("
					+ "SELECT t2.id FROM snapshots t2 WHERE t2.islast=1 AND  t2.project_id IN ("
					+ "SELECT t1.id FROM projects t1 WHERE t1.root_id ="
					+ "(SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.scope='FIL') ) ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getInt("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 统计类个数
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getClassesCount(Long projectName) {
		conn = DBManager.getConnection();
		Integer result = 0;
		try {
			String sql = " SELECT SUM(t3.value) as num FROM project_measures t3 WHERE t3.metric_id=6 AND t3.snapshot_id IN ("
					+ "SELECT t2.id FROM snapshots t2 WHERE t2.islast=1 AND  t2.project_id IN ("
					+ "SELECT t1.id FROM projects t1 WHERE t1.root_id ="
					+ "(SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.scope='FIL') ) ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getInt("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 统计目录个数
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getDirCount(Long projectName) {
		conn = DBManager.getConnection();
		Integer result = 0;
		try {
			String sql = " SELECT SUM(t3.value) as num FROM project_measures t3 WHERE t3.metric_id=8 AND t3.snapshot_id IN ("
					+ "SELECT t2.id FROM snapshots t2 WHERE t2.islast=1 AND  t2.project_id IN ("
					+ "SELECT t1.id FROM projects t1 WHERE t1.root_id ="
					+ "(SELECT t.id FROM projects t WHERE t.name='"
					+ projectName
					+ "' AND t.scope='PRJ') AND t1.scope='FIL') ) ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				result = rs.getInt("num");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return result;
	}

	/**
	 * 获取规范详细报告
	 * 
	 * @param projectName
	 * @return
	 */
	public List<NormDesc> getNormDetail(Long projectName, String level) {
		conn = DBManager.getConnection();
		List<NormDesc> normList = new ArrayList<NormDesc>();
		try {
			String sql = "SELECT  p.`path` as path,t1.`line` as lineNum,t1.`message` as message "
					+ " FROM issues t1 , projects p WHERE t1.root_component_id = "
					+ " (SELECT  t.id  FROM    projects t WHERE (t.name = '"
					+ projectName
					+ "'  ) AND t.scope = 'PRJ') "
					+ " AND t1.severity = '"
					+ level
					+ "' AND t1.`component_id`=p.`id` ";
			s = conn.createStatement();

			rs = s.executeQuery(sql);

			while (rs.next()) {
				NormDesc obj = new NormDesc();
				obj.setPath(rs.getString("path"));
				obj.setLineNum(rs.getInt("lineNum"));
				obj.setMessage(rs.getString("message"));
				normList.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			this.close();
		}
		return normList;
	}

	/**
	 * 关闭数据库操作相关属性
	 */
	private void close() {

		try {
			if (this.rs != null) {
				this.rs.close();
			}
			if (this.ps != null) {
				this.ps.close();
			}
			if (this.s != null) {
				this.s.close();
			}
			if (this.conn != null) {
				this.conn.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] args) { SonarDao sd = new SonarDao();
	 * Integer aaa = sd.getMajorCount("119"); System.out.println("dddddddd" +
	 * aaa); }
	 */
}
