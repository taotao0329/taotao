package com.chinasoft.pom;

import java.io.File;

public class Pom {

	/**
	 * 检查指定路径中是否存在指定的文件
	 * @return
	 */
	public static boolean checkPomXml(String workpath,String fileName) throws Exception{
		
		File file=new File(workpath+"\\"+fileName);
		System.out.println(file.exists());
		return file.exists();
	}
	
}
