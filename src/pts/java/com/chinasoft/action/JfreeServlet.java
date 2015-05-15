package com.chinasoft.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JfreeServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
//		PrintWriter writer = res.getWriter();
//		writer.write("test");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		String data1="[8.4, 9.8, 11.4, 15.6]";
		String data2="[9.2, 7.8, 10.2, 16.8]";
		String data3="[6.5, 9.4, 13.2, 18.6]";
		String data4="[8.03, 9, 11.6, 17]";
		req.setAttribute("data1", data1);
		req.setAttribute("data2", data2);
		req.setAttribute("data3", data3);
		req.setAttribute("data4", data4);
		req.getRequestDispatcher("pages/high.jsp").forward(req, res);
	}
}
