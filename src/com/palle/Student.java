package com.palle;

import java.sql.SQLException;

public class Student {

	public static void main(String[] args) {
		A a = new A();
		a.create();
		try {
			a.deleting(3);

		} 
		catch (ClassNotFoundException e1) 
		{
		
			e1.printStackTrace();
		}
		catch (SQLException e1) 
		{
			
			e1.printStackTrace();
		}
	}
}
	
	
	