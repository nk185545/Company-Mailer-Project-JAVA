package com.anproject;

import java.sql.* ;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int x = Integer.parseInt(request.getParameter("id")) ;
		String url="jdbc:mysql://127.0.0.1:3306/nishi";
		String un="root";
		String pwd="nishi@1425";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null ;
		try {
			con  = DriverManager.getConnection(url, un, pwd) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String query = "update companyMessage set trash='"+"no' "+" where id='"+x+"' " ;
		PreparedStatement pst = null ;
		try {
			 pst = con.prepareStatement(query) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			int c = pst.executeUpdate() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("InboxServlet").include(request, response);
		
	}

	

}