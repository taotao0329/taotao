package com.chinasoft.service;

import java.io.Serializable;

import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.entities.Tmp;

public interface ITmpService
{

	public Serializable saveTmp(String tmpName,int tmpCode,IBaseDAO<Tmp> dao);
}
