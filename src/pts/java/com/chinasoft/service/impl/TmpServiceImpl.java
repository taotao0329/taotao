//package com.chinasoft.service.impl;
//
//import java.io.Serializable;
//
//import org.springframework.stereotype.Service;
//
//import com.chinasoft.dbservice.dao.IBaseDAO;
//import com.chinasoft.entities.Tmp;
//import com.chinasoft.service.ITmpService;
//
//@Service("tmpService")
//public class TmpServiceImpl implements ITmpService
//{
//
//	@Override
//	public Serializable saveTmp(String tmpName, int tmpCode, IBaseDAO<Tmp> dao)
//	{
//		Tmp tmp = new Tmp();
//		tmp.setTmpCode(tmpCode);
//		tmp.setTmpName(tmpName);
//		return dao.save(tmp);
//	}
//
//	
//
//}
