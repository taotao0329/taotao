package com.chinasoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author db 用户实体类
 */
@Entity
@Table(name = "tbl_user", catalog = "test")
public class User implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 6664283413281508693L;
	// id
	@GenericGenerator(name = "test", strategy = "increment")
	@Id
	@GeneratedValue(generator = "test")
	@Column(name = "id", unique = true, nullable = false)
	private int					id;
	// 用户名
	@Column(name = "userName", length = 500)
	private String				userName;
	// 密码
	@Column(name = "passWord", length = 500)
	private String				passWord;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassWord()
	{
		return passWord;
	}

	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

}
