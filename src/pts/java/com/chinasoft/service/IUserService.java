package com.chinasoft.service;

import java.io.Serializable;

import com.chinasoft.entities.User;

public interface IUserService
{
	public Serializable saveUser(User user);
}
