package com.palle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class A 
{
	private static final String url = "\"jdbc:mysql://localhost:3306/jdbc\"";
	private static final String username = "root";
	private static final String password = "Pallavi@12.";
	private static Connection con = null;
	private static Statement s = null;
	private static PreparedStatement ps =null;
	public void create()
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url,username,password);
			s =con.createStatement();
			s.executeUpdate("create table std(sno, sname varchar(40), ssub varchar(40), email varchar(50)");
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
//							Read
	
	public static void read()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			String qry = "select * from student";
			ps = (PreparedStatement) con.createStatement();
			s = (Statement) ps.executeQuery(qry);
			while(((ResultSet) s).next())
			{
				System.out.println(((ResultSet) ps).getInt("sno"));
				System.out.println(((ResultSet) ps).getString("sname"));
				System.out.println(((ResultSet) ps).getString("sub"));
				System.out.println(((ResultSet) ps).getString("smail"));
			}
		} 
		catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps!=null)
				{
					ps.close();	
				}
				if(s!=null)
				{
					s.close();	
				}
				if(con!=null)
				{
					con.close();	
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void inserting(String sname, String ssub, String mail) throws ClassNotFoundException, SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url, username, password); 
			
			ps = con.prepareStatement("insert into std(sname, ssub, smail) values(?,?,?)");
			ps.setString(1, sname);
			ps.setString(2, ssub);
			ps.setString(3, mail);
			ps.executeUpdate();
			ps.close();
			con.close();
		}
		 catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void updating(int sno, String sub, String email, int sid) throws ClassNotFoundException, SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url, username, password);
			
			ps = con.prepareStatement("update std set sno=?, ssub=?,email=? where sid=?");
			ps.setInt(1, sno);
			ps.setString(2, sub);
			ps.setString(3, email);
			ps.setInt(4, sid);
			ps.executeUpdate();
			ps.close();
			con.close();
		}
		 catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
//	                     deleting
	public void deleting(int id) throws ClassNotFoundException, SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url, username, password);
			
			ps = con.prepareStatement("delete from std where eid = ?");
	
			ps.setInt(1, id);
		
//			ps.executeUpdate();
			ps.close();
			con.close();
		}
		 catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}

