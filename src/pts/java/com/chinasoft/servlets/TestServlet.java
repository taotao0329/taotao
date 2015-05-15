package com.chinasoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 6822428264819908840L;
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter writer = res.getWriter();
		writer.println("test B");
		req.getRequestDispatcher("pages/result.jsp");
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		doPost(req, res);
	}
	
}
