package com.chinasoft.servlets;

import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.chinasoft.dbservice.dao.IBaseDAO;
import com.chinasoft.service.ITmpService;


public class TmpServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -8098407880110427387L;
	
	
	private static final Logger logger = Logger.getLogger(TmpServlet.class);
	
	public TmpServlet()
	{
		super();
	}//TmpServlet
	
	private IBaseDAO getDaoToIOC()
	{
		WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this
				.getServletContext());
		IBaseDAO baseDao = (IBaseDAO) applicationContext.getBean("baseDao");
		return baseDao;
	}// getDaoToIOC
	
	private ITmpService getServiceToIoc(String serviceName)
	{
		WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this
				.getServletContext());
		ITmpService userService = (ITmpService) applicationContext.getBean(serviceName);
		return userService;
	}// getServiceToIoc
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		logger.debug("start TmpServlet...");
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		String tmpName = req.getParameter("tmpName");
		int tmpCode = Integer.parseInt(req.getParameter("tmpCode"));
		ITmpService tmpService = getServiceToIoc("tmpService");
		int resu = (int)tmpService.saveTmp(tmpName, tmpCode, getDaoToIOC());
		if(resu >0)
		{
			PrintStream writer = new PrintStream(res.getOutputStream(), true);
			writer.println("<html><head><title>Result</title></head");
			writer.println("<body> TmpName:" + tmpName + "<br>");
			writer.println("tmpCode:" + tmpCode + "<br></body></html>");
			writer.close();
		}
		logger.debug("end TmpServlet...");
	}//doPost
}
