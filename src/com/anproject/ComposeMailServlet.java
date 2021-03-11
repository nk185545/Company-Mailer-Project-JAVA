package com.anproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ComposeMailServlet")
public class ComposeMailServlet extends HttpServlet 
{
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("html/text") ;
		PrintWriter out=response.getWriter();
	    String fm = request.getParameter("from") ;
		String t = request.getParameter("to") ;
		String sub = request.getParameter("subject") ;
		String mess = request.getParameter("message") ;
		
		try {
			ComposeMailDao.saveMail(fm,t,sub,mess) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("header.html");
		response.sendRedirect("OutboxServlet");
		
		
	}

}