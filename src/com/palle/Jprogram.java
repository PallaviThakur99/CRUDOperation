package com.palle;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jprogram {

	public static void main(String[] args) {
		Connection con = null;
		Statement s = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pallavi@12.");
			s = con.createStatement();
			String qry = "select * from emp";
			ResultSet rs = s.executeQuery(qry);
			while(rs.next()==true)
			{
				System.out.println(rs.getInt("eno"));
				System.out.println(rs.getString("ename"));
						
			}
			
		} catch (ClassNotFoundException e) 
		{
		
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally 
		{
		try {
			if(s != null) {
				s.close();
			}
			if(con != null) 
			{
				con.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		}
		}
	}
		
		