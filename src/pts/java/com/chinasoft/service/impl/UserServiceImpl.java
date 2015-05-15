//package com.chinasoft.service.impl;
//
//import java.io.Serializable;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.chinasoft.entities.User;
//import com.chinasoft.service.IUserService;
//import com.chinasoft.dbservice.dao.*;
//
//@Service("userService")
//public class UserServiceImpl implements IUserService
//{
//
//	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
//	@Autowired
//	private IBaseDAO<User> baseDao;
//	
//	@Override
//	public Serializable saveUser(User user)
//	{
//		logger.debug("exe saveUser method and params[user:'"+user+"']");
//		return baseDao.save(user);
//	}
//
//}
