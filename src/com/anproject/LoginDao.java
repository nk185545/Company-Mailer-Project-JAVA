package com.anproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDao {
	public static boolean validate(String username,String password) throws Exception
	{
		String url="jdbc:mysql://127.0.0.1:3306/nishi";
		String un="root";
		String pwd="nishi@1425";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,un,pwd);
		if(username!=null && password!=null)
		{
			String query="select * from companyRegistration where email='"+username+"' and pass='"+password+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
			{
				st.close();
				con.close();
				return true;
			}
			st.close();
			con.close();
			return false;
		}
		con.close();
		return false;
	}
		
	}

