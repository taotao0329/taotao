package com.framework.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chinasoft.dao.CompileDescDao;
import com.chinasoft.dbservice.dao.IBaseDAO;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class Test
{
	
	public static void main(String [] args) throws IOException
	{
//		BeanFactory bean =  new ClassPathXmlApplicationContext("classpath*:spring/frame/config/spring-config/persistApplicationContext.xml");
//		ComboPooledDataSource dataSource =(ComboPooledDataSource) bean.getBean("dataSource");
//		System.out.println(dataSource.getUser());
//		SessionFactoryImpl sess = (SessionFactoryImpl)bean.getBean("sessionFactory");
//		Properties pro = sess.getProperties();
//		System.out.println(pro.get("hibernate.hbm2ddl.auto"));
//		IBaseDAO<String> bean2 = (IBaseDAO<String>) bean.getBean("baseDao");
//		System.out.println(bean2);
//		CompileDescDao cdao= (CompileDescDao)bean.getBean("compileDescDaoImpl");
		Test t = new Test();
		t.test();
		System.out.println(File.separator);
	}//main
	
	private void test() throws IOException
	{
//		Properties pro = new Properties();
//		InputStream stream = this.getClass().getClassLoader().getResourceAsStream("assembly.properties");
//		pro.load(stream);
//		System.out.println(pro.get("PtsServiceHost"));
//		System.out.println(this.getClass().getResource("/").getPath());
		String test = this.getClass().getClassLoader().getResource("").getPath();
		System.out.println(test);
		String path = this.getClass().getClassLoader().getResource("test.xml").getPath();
		System.out.println(">>>>"+test+"test.xml");
		FileInputStream fil = new FileInputStream(new File(path));
		System.out.println(fil);
		
		 System.out.println(path);
	}
}
