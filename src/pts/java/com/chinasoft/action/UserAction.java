//package com.chinasoft.action;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import com.chinasoft.entities.User;
//import com.chinasoft.service.IUserService;
//import com.opensymphony.xwork2.Action;
//import com.opensymphony.xwork2.ActionSupport;
//
//
//@Controller("userAction")
//public class UserAction extends ActionSupport
//{
//	private static final Logger logger = Logger.getLogger(UserAction.class);
//	@Autowired
//	private IUserService userService;
//	
//	private User user;
//	
//	public String save()
//	{
//		logger.debug(System.getProperty("webapp.root"));
//		logger.debug("start execute UserAction save method...");
//		userService.saveUser(user);
//		logger.debug("end execute UserAction...");
//		return Action.SUCCESS;
//	}
//
//	public User getUser()
//	{
//		return user;
//	}
//
//	public void setUser(User user)
//	{
//		this.user = user;
//	}
//	
//	
//}
