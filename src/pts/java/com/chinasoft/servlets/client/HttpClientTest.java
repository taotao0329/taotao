package com.chinasoft.servlets.client;
import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

public class HttpClientTest
{
	
	public static final Logger logger = Logger.getLogger(HttpClientTest.class);
	
	public static void main(String [] args)
	{
		HttpClientTest test = new HttpClientTest();
		System.out.println(test.test());
	}//main
	
	public String test()
	{
		//响应结果
		String resu="";
		//目标servlet的uri
		String uri="http://localhost:8080/pts/tmpServlet";
		//实例化httpClient
		HttpClient client = new HttpClient();
		//实例化post方法
		
		PostMethod method  = new PostMethod(uri);
		//构建参数
		NameValuePair[] data = {new NameValuePair("tmpName","tmpName"),new NameValuePair("tmpCode","123")};
		//将参数set到post中
		method.setRequestBody(data);
		try
		{
			//设置传输的字符集
			client.getParams().setContentCharset("UTF-8");
			//http返回的状态码 200 成功
			int status = client.executeMethod(method);
			if(status == 200)
			{
				//响应结果
				resu = method.getResponseBodyAsString();
			}
		}catch(IllegalArgumentException  e)
		{
			e.printStackTrace();
		}
		catch (HttpException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}finally
		{
			method.releaseConnection();
		}
		
		return resu;
	}//test
}
