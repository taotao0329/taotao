package com.chinasoft.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//读取assembly.properties文件信息
public class PropertiesUtil {

	 private static Properties config = null;
	
	static {
		  InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(
		    "/assembly.properties");
		  config = new Properties();
		  try {
		   config.load(in);
		   in.close();
		  } catch (IOException e) {
		   System.out.println("No AreaPhone.properties defined error");
		  }
		 }
	
	
	public static String readValue(String key) {
		  // Properties props = new Properties();
		  try {
		   String value = config.getProperty(key);
		   return value;
		  } catch (Exception e) {
		   e.printStackTrace();
		   System.err.println("ConfigInfoError" + e.toString());
		   return null;
		  }
		 }
	
}
