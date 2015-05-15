package com.chinasoft.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import com.chinasoft.common.tools.OperationException;

public class HttpClientUtil
{

	private static final Logger	logger	= Logger.getLogger(HttpClient.class);

	private String				url		= "";

	private String				method	= "post";

	public HttpClientUtil(String url, String method)
	{
		this.url = url;
		if (method != null && !method.equals(""))
		{
			this.method = method;
		}
	}

	public String callUrl()
	{
		/**
		 * 
		 */
		logger.debug(Thread.currentThread().getName()+">>>>invoke servlet the url:{'" + url + "'}");
		if (this.url.equals(""))
		{
			return "false";
		}
//		PostMethod postMethod = null;
//		GetMethod getMethod = null;
		HttpMethodBase baseMethod =  null;
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		// 这里的超时单位是毫秒 ms 这里为3分钟
		client.getHttpConnectionManager().getParams().setConnectionTimeout(180 * 1000);
		String result = "";
		if (this.method.equals("post"))
		{
			baseMethod = new PostMethod(this.url);
		}
		else
		{
			baseMethod = new GetMethod(this.url);
		}
		int status = 0;
		try
		{

			status = client.executeMethod(baseMethod);
			result = (status==200 ?baseMethod.getResponseBodyAsString() :"error");
			logger.debug("invoke servlet reponse state:{'" + status + "'}");
			logger.debug("invoke servlet reponse dataText:{'" + result + "'}");
			return result;
		}
		catch (HttpException e)
		{
			//异常往上抛
			throw new OperationException("OperationException{This TimeOut exception}",e);
		}
		catch (IOException e)
		{
			//异常往上抛
			throw new OperationException("OperationException{This interaction exception}",e);
		}
		catch(Exception e)
		{
			//异常往上抛
			throw new OperationException("OperationException{This others exception}",e);
		}
		finally
		{
			if (baseMethod != null)
			{
				baseMethod.releaseConnection();
			}
		}

	}

	public static void main(String[] args)
	{

		String url = "http://172.16.3.28:8080/pts/inspection/inspection_refreshPage.action";
		HttpClientUtil client = new HttpClientUtil(url, "");
		String result = client.callUrl();
		System.out.println("dddddddddddddddddddddddddddddddddddddddddddd" + result);

	}

}
