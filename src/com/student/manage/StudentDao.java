package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	public static boolean insertStudentToDB(Student st) {
		boolean f=false;
			
		try {
			//JDBC CODE
			Connection con=Cp.createC();
			String q="insert into Students(sname,sphone) values(?,?)";
			//PreparedStatement
			PreparedStatement pstmt=con.prepareStatement(q);
			//SET the value of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			//execute..
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e) {
			//handle exception
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userId) {
		// TODO Auto-generated method stub
		boolean f=false;
		
		try {
			//JDBC CODE
			Connection con=Cp.createC();
			String q="delete from Students where sid=?";
			//PreparedStatement
			PreparedStatement pstmt=con.prepareStatement(q);
			//SET the value of parameter
			pstmt.setInt(1, userId);
			
			//execute..
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e) {
			//handle exception
			e.printStackTrace();
		}
		return f;
	}

	public static void showAllStudent() {
		// TODO Auto-generated method stub

		
		try {
			//JDBC CODE
			Connection con=Cp.createC();
			String q="select * from students ";
			Statement stmt=con.createStatement();
			ResultSet set=stmt.executeQuery(q);
			while(set.next())
			{
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone=set.getString(3);
				System.out.println("ID:"+id);
				System.out.println("NAME"+name);
				System.out.println("PHONE"+phone);
				System.out.println("++++++++++++++++++++++");
			}
			
		}catch(Exception e) {
			//handle exception
			e.printStackTrace();
		}
	}

	
}
